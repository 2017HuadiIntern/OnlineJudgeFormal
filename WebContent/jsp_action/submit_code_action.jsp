<%@page import="record_management.Record"%>
<%@page import="org.json.XML"%>
<%@page import="helper.XMLHelper"%>
<%@page import="helper.DBHelper.DBObjectType"%>
<%@page import="problem_management.Problem"%>
<%@page import="helper.DBHelper"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="record_management.RecordFactory"%>
<%@page import="record_management.SubmitRecord"%>
<%@page import="helper.CompileHelper.CompileResult"%>
<%@page import="helper.CompileHelper"%>
<%@page import="helper.ConfHelper"%>
<%@page import="java.io.*" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<% 
/* 提供提交代码的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
 %>
<%
/* 获取提交表单参数 */
System.out.println("problemID="+request.getParameter(ConfHelper.REQUEST_PROBLEM_ID));
String UserName = request.getParameter(ConfHelper.REQUEST_USER_NAME);
int ProblemID = Integer.parseInt(request.getParameter(ConfHelper.REQUEST_PROBLEM_ID));
//int ProblemID = 2;
String CodeText = request.getParameter(ConfHelper.REQUEST_CODE_TEXT);// 代码
System.out.print("code content:\r\n"+CodeText+"\r\n");
%>
<%
/* 创建代码文件 */
CompileHelper compileHelper = new CompileHelper(new ConfHelper(basePath+"\\"+ConfHelper.CONF_FILE_RELATED_PATH));
String codeFilePath = compileHelper.genCodeFilePath(UserName, ProblemID +"");// 生成代码文件路径
File codeFile = new File(codeFilePath);
OutputStream codeStream = new FileOutputStream(codeFile);
PrintWriter codeWriter = new PrintWriter(codeStream);
if(CodeText==null){
   	codeWriter.flush();
    codeWriter.close();
    codeStream.close();
	return;
}     
codeWriter.write(CodeText);
codeWriter.flush();
codeWriter.close();
codeStream.close();
%>
<%
/*执行编译操作*/

CompileResult compileResult = compileHelper.doCompile(codeFilePath);// 获取编译结果
%>
<%
/* 打印编译结果 */
System.out.print(compileResult.getInfo()+"\r\n");// 输出编译信息
// 如果编译失败，在此处生成记录
if(!compileResult.isSucess()){
	ArrayList<SubmitRecord> submitList = new ArrayList<SubmitRecord>(); 
	SubmitRecord submitRecord = RecordFactory.createSubmitRecord();
	submitRecord.setCaseID(-1);
	submitRecord.setCompileInfo(compileResult.getInfo());
	submitRecord.setExecInfo("编译出错!");
	submitList.add(submitRecord);
	JSONArray jsonArray = JSONArray.fromObject(submitList);
	String json = jsonArray.toString();
	/* 打印json */
	System.out.print("compile json:\r\n" + json+"\r\n");
	response.getWriter().print(json);
	return;
}
%>
<%
/* 执行，并输出执行结果 */
/* 获取输入用例 */
DBHelper dbHelper = new DBHelper(new ConfHelper(basePath+"\\"+ConfHelper.CONF_FILE_RELATED_PATH));
Problem problem = (Problem)dbHelper.getDBObject(dbHelper.ProblemTable_ID, ProblemID, DBObjectType.TYPE_PROBLEM).get(0);// 获取题目数据
dbHelper.disconnectDB();
ArrayList<SubmitRecord> execResults = new ArrayList<SubmitRecord>();
String inputCases = problem.getInputCase();
String outputCases = problem.getOutputCase();
System.out.print("input case:\r\n"+inputCases+"\r\n");
HashMap<String, String> inputCaseMap = XMLHelper.getDataFromXML(inputCases);
HashMap<String, String> outputCaseMap = XMLHelper.getDataFromXML(outputCases);
int caseCount = inputCaseMap.size();
int score=0;// 分数
System.out.println("case map:"+outputCaseMap.get("output0"));
/* 执行程序 */
for(int i=0;i<caseCount;i++){
	CompileResult execRes = compileHelper.doExec(codeFilePath+".exe", inputCaseMap.get("input"+i));// 获取执行结果
	if(execRes!=null)System.out.println("exec:" + execRes.getInfo().replace("\r|\n", ""));
	System.out.println("outputCase:"+outputCaseMap.get("output"+i));
	if(execRes.getInfo().replace("\r|\n", "").equals(outputCaseMap.get("output"+i)+"\r\n")){
		execRes.setSucess(true);
		++score;
	}else{
		execRes.setSucess(false);
	}
	SubmitRecord sr = RecordFactory.createSubmitRecord();
	sr.setCaseID(i);
	sr.setCompileInfo(compileResult.getInfo());
	sr.setExecInfo(execRes.getInfo());
	sr.setInputCase(inputCaseMap.get("input"+i));
	sr.setOutputCase(outputCaseMap.get("output"+i));
	execResults.add(sr);
}
%>
<%
JSONArray jsonArray = JSONArray.fromObject(execResults);
String json = jsonArray.toString();
System.out.print("exec json:\r\n"+json);
response.getWriter().print(json);
%>
<%
/* 保存做题记录 */
dbHelper = new DBHelper(new ConfHelper(basePath+"\\"+ConfHelper.CONF_FILE_RELATED_PATH));
ArrayList<Object> recordList = dbHelper.execMySQLQuery("select * from " + dbHelper.RecordTable + ";", DBObjectType.TYPE_RECORD);
System.out.print(recordList.get(0)+"\r\n");
int newID = 1;
int tempID;
for(int i=0;i<recordList.size();i++){
	tempID = ((Record)recordList.get(i)).getID();
	if((((Record)recordList.get(i)).getProblemID()==ProblemID)&&(((Record)recordList.get(i)).getUserName()==UserName)){
		newID=tempID;
		break;
	}
	if(tempID >= newID)newID = tempID + 1;
}
Record newRecord = RecordFactory.createRecord();
newRecord.setID(newID);
newRecord.setProblemID(ProblemID);
newRecord.setUserName(UserName);
newRecord.setResult(score);
newRecord.setTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
dbHelper.createOrModifyDBOject(newRecord, DBObjectType.TYPE_RECORD);
dbHelper.disconnectDB();
%>
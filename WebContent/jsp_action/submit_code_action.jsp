<%@page import="record_management.RecordFactory"%>
<%@page import="record_management.SubmitRecord"%>
<%@page import="helper.CompileHelper.CompileResult"%>
<%@page import="helper.CompileHelper"%>
<%@page import="helper.ConfHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<% 
/* 提供提交代码的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
 %>
<%
/* 获取提交表单参数 */
String UserName = request.getParameter(ConfHelper.REQUEST_USER_NAME);
int ProblemID = Integer.parseInt(request.getParameter(ConfHelper.REQUEST_PROBLEM_ID));
String CodeText = request.getParameter(ConfHelper.REQUEST_CODE_TEXT);// 代码

%>
<%
/*执行编译操作*/
CompileHelper compileHelper = new CompileHelper(new ConfHelper(basePath+"\\"+ConfHelper.CONF_FILE_RELATED_PATH));
String codeFileName = compileHelper.genCodeFilePath(UserName, ProblemID +"");// 生成代码文件路径
CompileResult compileResult = compileHelper.doCompile(codeFileName);// 获取编译结果
%>
<%
/* 打印编译结果 */
System.out.print(compileResult.getInfo()+"\r\n");// 输出编译信息
// 如果编译失败，在此处生成记录
if(!compileResult.isSucess()){
	SubmitRecord submitRecord = RecordFactory.createSubmitRecord();
	submitRecord.setCaseID(-1);
	submitRecord.setCompileInfo(compileResult.getInfo());
	submitRecord.setExecInfo("编译出错!");
	
	return;
}
%>
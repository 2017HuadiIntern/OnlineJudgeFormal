<%@page import="net.sf.json.JSONArray"%>
<%@page import="problem_management.Problem"%>
<%@page import="problem_management.ProblemFactory"%>
<%@page import="problem_management.ProblemList"%>
<%@page import="problem_management.ProblemListItem"%>
<%@page import="helper.JSONHelper"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="user_management.UserFactory"%>
<%@page import="helper.ConfHelper"%>
<%@page import="helper.DBHelper.DBObjectType"%>
<%@page import="user_management.User"%>
<%@page import="helper.DBHelper"%>
<%@page import="helper.StringHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<% 
/* 提供获取题目列表的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
 %>
<%
/* 获取请求参数 */
int pageNum = Integer.parseInt(request.getParameter(ConfHelper.REQUEST_PROBLEM_LIST_PAGE));// 页码号
%>
<%
/* 从数据库中获取指定页码的数据 */
final int CountPerPage = 10;// 每页最多显示的条目数
int limit_up = (pageNum - 1) * 10;// 数据区域上限
int limit_down = (pageNum) * 10;// 数据区域下限
DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
ArrayList<Object> objectList = dbHelper.execMySQLQuery("select * from " + dbHelper.ProblemTable + " limit " + limit_up + "," + limit_down +";", DBObjectType.TYPE_PROBLEM);
dbHelper.disconnectDB();
%>
<%
/* 转成JSON报文并发送 */
ProblemListItem[] problemList = new ProblemListItem[objectList.size()];
for(int i=0;i<objectList.size();i++){
	ProblemListItem plt = ProblemFactory.createProblemListItem();
	plt.setID(((Problem)objectList.get(i)).getID());
	plt.setTitle(((Problem)objectList.get(i)).getTitle());
	plt.setProposer(((Problem)objectList.get(i)).getProposer());
	problemList[i]=plt;
}
JSONArray jsonArray = JSONArray.fromObject(problemList);
String json = jsonArray.toString();
System.out.print(json+"\r\n");
response.getWriter().print(json);
%>
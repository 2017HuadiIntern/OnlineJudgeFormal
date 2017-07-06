package helper;

import java.sql.*;
import java.sql.Connection;


/**
 * 数据库助手
 * @author 屈彬
 *
 */
public class DBHelper {
	/**
	 * 数据库连接器
	 */
	Connection MySQLConn;
	/* 数据库访问参数  */
	String DriverName;
	String URL;
	String UserName;
	String Password;
	String DatabaseName;
	String UserTable;
	String ProblemTable;
	String RecordTable;
	/* 表列名  */
	String UserTable_Name;
	String UserTable_Password;
	String ProblemTable_ID;
	String ProblemTable_Title;
	String ProblemTable_Description;
	String ProblemTable_InputCase;
	String ProblemTable_OutputCase;
	String ProblemTable_Proposer;
	String RecordTable_ID;
	String RecordTable_Solver;
	String RecordTable_ProblemID;
	String RecordTable_Time;
	String RecordTable_Result;
	/**
	 * 数据库对象类型枚举
	 * @author 屈彬
	 *
	 */
	public enum DBObjectType{
		TYPE_USER, TYPE_PROBLEM, TYPE_RECORD;
	}
	/**
	 * 构造函数
	 */
	public DBHelper(){
		initiatDBHelper();
	}
	/**
	 * 初始化数据库助手
	 */
	protected void initiatDBHelper(){
		loadConfigure();
		connectDB();
	}
	/**
	 * 加载配置
	 */
	protected void loadConfigure(){

		ConfHelper confHelper = new ConfHelper();
		
		DriverName = confHelper.getConfValue("DBDriver");
		URL = confHelper.getConfValue("DBURL");
		UserName = confHelper.getConfValue("DBUserName");
		Password = confHelper.getConfValue("DBPassword");
		DatabaseName = confHelper.getConfValue("DBName");
		UserTable = confHelper.getConfValue("UserTable");
		ProblemTable = confHelper.getConfValue("ProblemTable");
		RecordTable = confHelper.getConfValue("RecordTable");
		
		UserTable_Name = confHelper.getConfValue("UserTable_Name");
		UserTable_Password = confHelper.getConfValue("UserTable_Password");
		ProblemTable_ID = confHelper.getConfValue("ProblemTable_ID");
		ProblemTable_Title = confHelper.getConfValue("ProblemTable_Title");
		ProblemTable_Description = confHelper.getConfValue("ProblemTable_Description");
		ProblemTable_InputCase = confHelper.getConfValue("ProblemTable_InputCase");
		ProblemTable_OutputCase = confHelper.getConfValue("ProblemTable_OutputCase");
		ProblemTable_Proposer = confHelper.getConfValue("ProblemTable_Proposer");
		RecordTable_ID = confHelper.getConfValue("RecordTable_ID");
		RecordTable_Solver = confHelper.getConfValue("RecordTable_Solver");
		RecordTable_ProblemID = confHelper.getConfValue("RecordTable_ProblemID");
		RecordTable_Time = confHelper.getConfValue("RecordTable_Time");
		RecordTable_Result = confHelper.getConfValue("RecordTable_Result");
	}
	/**
	 * 连接数据库
	 */
	protected void connectDB(){
		try{
			Class.forName(DriverName);// 加载驱动程序
			System.out.println("load MySQL driver sucess!");
			MySQLConn = DriverManager.getConnection(URL, UserName, Password);
			if(!MySQLConn.isClosed())System.out.println("sucess connect!");// 判断是否成功连接
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
	}
	/**
	 * 设置数据库地址
	 * @param URL 数据库地址
	 */
	public void setURL(String URL){this.URL=URL;}
	/**
	 * 设置数据库登录用户名
	 * @param UserName 数据库登录用户名
	 */
	public void setUserName(String UserName){this.UserName=UserName;}
	/**
	 * 设置数据库登录密码
	 * @param Password 数据库登录密码
	 */
	public void setPassword(String Password){this.Password=Password;}
	/**
	 * 设置数据库名称
	 * @param DatabaseName 设置数据库名称
	 */
	public void setDatabaseName(String DatabaseName){this.DatabaseName=DatabaseName;}
	/**
	 * 设置数据库表名
	 * @param TableName 表名
	 * @param type 数据库对象类型
	 */
	public void setTableName(String TableName, DBObjectType type){
		switch (type) {
		case TYPE_USER:
			UserTable = TableName;
			break;
		case TYPE_PROBLEM:
			ProblemTable = TableName;
			break;
		case TYPE_RECORD:
			RecordTable = TableName;
			break;
		default:
			break;
		}
	}
	
	/**
	 * 在数据库中根据对象类型创建元组
	 * @param object 待创建对象
	 * @param type 数据库对象类型
	 * @return 是否创建成功
	 */
	public boolean createDBObject(Object object, DBObjectType type){
		// undone
		return true;
	}
	/**
	 * 在数据库中根据对象类型修改元组
	 * @param key 主键
	 * @param type 对象类型
	 * @return 是否修改成功
	 */
	public boolean modifyDBOject(Object key, DBObjectType type){
		// undone
		return true;
	}
	/**
	 * 获取数据库对象
	 * @param key 主键
	 * @param type 对象类型
	 * @return 对象
	 */
	public Object getDBObject(Object key, DBObjectType type){
		// undone
		return true;
	}
	/**
	 * 移出数据库对象
	 * @param key 主键
	 * @param type 对象类型
	 * @return 是否操作成功
	 */
	public boolean removeDBObject(Object key, DBObjectType type){
		// undone
		return true;
	}
}

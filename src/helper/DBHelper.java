package helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import problem_management.Problem;
import problem_management.ProblemFactory;
import record_management.Record;
import record_management.RecordFactory;
import user_management.User;
import user_management.UserFactory;


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
	/**
	 * 配置助手
	 */
	ConfHelper confHelper;
	/* 数据库访问参数  */
	String DriverName;
	String URL;
	String UserName;
	String Password;
	String DatabaseName;
	public String UserTable;
	public String ProblemTable;
	public String RecordTable;
	/* 表列名  */
	public String UserTable_Name;
	public String UserTable_Password;
	public String ProblemTable_ID;
	public String ProblemTable_Title;
	public String ProblemTable_Description;
	public String ProblemTable_InputCase;
	public String ProblemTable_OutputCase;
	public String ProblemTable_Proposer;
	public String RecordTable_ID;
	public String RecordTable_Solver;
	public String RecordTable_ProblemID;
	public String RecordTable_Time;
	public String RecordTable_Result;
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
	public DBHelper(ConfHelper confHelper){
		this.confHelper = confHelper;
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
	 * 断开连接
	 */
	public void disconnectDB(){
		if(MySQLConn==null)return;
		try {
			if(!MySQLConn.isClosed())MySQLConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 加载配置
	 */
	protected void loadConfigure(){
		
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
			System.out.println("log to mysql -h " + URL + " -u " + UserName + " -p " + Password);
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
		if(MySQLConn==null)return false;
		try{
			if(MySQLConn.isClosed())return false;
			Statement statement = MySQLConn.createStatement();
			String sqlCmd = "";
			switch (type) {
			case TYPE_USER:
				sqlCmd = "insert into " + UserTable + "(" + UserTable_Name + "," + UserTable_Password + ")values('" + ((User)object).getUserName() +
					"','" + ((User)object).getPassword() + "');";
				break;
			case TYPE_PROBLEM:
				Problem problem = (Problem)object;
				sqlCmd = "insert into " + ProblemTable + "(" + ProblemTable_ID + "," + ProblemTable_Title + "," + ProblemTable_Description + "," + 
						ProblemTable_InputCase + "," + ProblemTable_OutputCase + "," + ProblemTable_Proposer + 
						")values(" + problem.getID() + ",'" + problem.getTitle() + "','" + problem.getDescription() + "','" + problem.getInputCase() +
						"','" + problem.getOutputCase() + "','" + problem.getProposer() + "');";
				break;
			case TYPE_RECORD:
				Record record = (Record)object;
				sqlCmd = "insert into " + RecordTable + "(" + RecordTable_ID + "," + RecordTable_Solver + "," + RecordTable_ProblemID + "," + RecordTable_Result +
						"," + RecordTable_Time + ")values(" + record.getID() + ",'" + record.getUserName() + "'," + record.getProblemID() + ",'" + record.getResult() +
						"','" + record.getTime() + "');";
				break;
			default:
				break;
			}
			System.out.println(sqlCmd);
			if(!sqlCmd.isEmpty())statement.execute(sqlCmd);
			else System.out.println("sql cmd is empty!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			
		}
		return true;
	}
	/**
	 * 在数据库中根据对象类型修改元组
	 * @param key 键
	 * @param keyValue 键值
	 * @param type 对象类型
	 * @param modifyColumn 被修改的列的列名
	 * @param modifyValue 新的值
	 * @return 是否修改成功
	 */
	public boolean modifyDBOject(String key, Object keyValue, String modifyColumn, Object modifyValue, DBObjectType type) {
		if(MySQLConn==null)return false;
		try{
			if(MySQLConn.isClosed()){
				System.out.println("db connector is closed!");
				return false;
			}
			String sqlCmd = "update ";
			switch (type) {
			case TYPE_USER:
				sqlCmd += UserTable;
				break;
			case TYPE_PROBLEM:
				sqlCmd += ProblemTable;
				break;
			case TYPE_RECORD:
				sqlCmd += RecordTable;
				break;
			default:
				break;
			}
			sqlCmd += " set " + modifyColumn + "=";
			if(modifyValue.getClass().equals(String.class))sqlCmd += "'" + modifyValue.toString() + "' ";
			else sqlCmd += modifyValue.toString() + " ";
			sqlCmd += "where " + key + "=";
			if(keyValue.getClass().equals(String.class))sqlCmd += "'" + keyValue.toString() + "';";
			else sqlCmd += keyValue.toString() + ";";
			System.out.println(sqlCmd);
			Statement statement = MySQLConn.createStatement();
			if(!sqlCmd.isEmpty())statement.execute(sqlCmd);
			else System.out.println("sql cmd is empty!");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			
		}
		return true;
	}
	/**
	 * 获取数据库对象
	 * @param key 键
	 * @param keyValue 键值
	 * @param type 对象类型
	 * @return 对象
	 */
	public ArrayList<Object> getDBObject(String key, Object keyValue, DBObjectType type){
		if(MySQLConn==null)return null;
		ArrayList<Object> result = new ArrayList<Object>();
		try {
			if(MySQLConn.isClosed())return null;
			Statement statement = MySQLConn.createStatement();
			String sqlCmd;
			ResultSet resultSet;
			switch (type) {
			case TYPE_USER:
				if(keyValue.getClass().equals(String.class))sqlCmd = "select * from " + UserTable + " where " + key.toString() + "='" + keyValue.toString() + "';";
				else sqlCmd = "select * from " + UserTable + " where " + key.toString() + "=" + keyValue.toString() + ";";
				System.out.println(sqlCmd);
				resultSet = statement.executeQuery(sqlCmd);
				while(resultSet.next()){
					User user = UserFactory.createUser();
					user.setUserName(resultSet.getString(UserTable_Name));
					user.setPassword(resultSet.getString(UserTable_Password));
					result.add(user);
				}
				break;
			case TYPE_PROBLEM:
				if(keyValue.getClass().equals(String.class))sqlCmd = "select * from " + ProblemTable + " where " + key.toString() + "='" + keyValue.toString() + "';";
				else sqlCmd = "select * from " + ProblemTable + " where " + key.toString() + "=" + keyValue.toString() + ";";
				System.out.println(sqlCmd);
				resultSet = statement.executeQuery(sqlCmd);
				while(resultSet.next()){
					Problem problem = ProblemFactory.createProblem();
					problem.setID(resultSet.getInt(ProblemTable_ID));
					problem.setTitle(resultSet.getString(ProblemTable_Title));
					problem.setDescription(resultSet.getString(ProblemTable_Description));
					problem.setInputCase(resultSet.getString(ProblemTable_InputCase));
					problem.setOutputCase(resultSet.getString(ProblemTable_OutputCase));
					problem.setProposer(resultSet.getString(ProblemTable_Proposer));
					result.add(problem);
				}
				break;
			case TYPE_RECORD:
				if(keyValue.getClass().equals(String.class))sqlCmd = "select * from " + RecordTable + " where " + key.toString() + "='" + keyValue.toString() + "';";
				else sqlCmd = "select * from " + RecordTable + " where " + key.toString() + "=" + keyValue.toString() + ";";
				System.out.println(sqlCmd);
				resultSet = statement.executeQuery(sqlCmd);
				while(resultSet.next()){
					Record record = RecordFactory.createRecord();
					record.setID(resultSet.getInt(RecordTable_ID));
					record.setUserName(resultSet.getString(RecordTable_Solver));
					record.setProblemID(resultSet.getInt(RecordTable_ProblemID));
					record.setResult(resultSet.getInt(RecordTable_Result));
					record.setTime(resultSet.getDate(RecordTable_Time).toString());
					result.add(record);
				}
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 移出数据库对象
	 * @param key 键
	 * @param keyValue 键值
	 * @param type 对象类型
	 * @return 是否操作成功
	 */
	public boolean removeDBObject(String key, Object keyValue, DBObjectType type){
		if(MySQLConn==null){
			System.out.println("connector is null!");
			return false;
		}
		try{
			if(MySQLConn.isClosed()){
				System.out.println("connector is closed!");
				return false;
			}
			String sqlCmd = "delete from ";
			switch (type) {
			case TYPE_USER:
				sqlCmd += UserTable;
				break;
			case TYPE_PROBLEM:
				sqlCmd += ProblemTable;
				break;
			case TYPE_RECORD:
				sqlCmd += RecordTable;
				break;
			default:
				break;
			}
			sqlCmd += " where " + key + "=";
			if(keyValue.getClass().equals(String.class))sqlCmd += "'" + keyValue.toString() + "';";
			else sqlCmd += keyValue.toString() + ";";
			System.out.println(sqlCmd);
			Statement statement = MySQLConn.createStatement();
			if(!sqlCmd.isEmpty())statement.execute(sqlCmd);
			else System.out.println("sql cmd is empty!");	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			
		}
		return true;
	}
	/**
	 * 执行MySQL语句
	 * @param MySQLCmd 执行语句
	 * @return 是否执行成功
	 */
	public boolean execMySQLAction(String MySQLCmd){
		if(MySQLConn==null){
			System.out.println("connector is null");
			return false;
		}
		if(MySQLCmd.isEmpty()){
			System.out.println("cmd is empty");
			return false;
		}
		try{
			if(MySQLConn.isClosed()){
				System.out.println("connector is closed");
				return false;
			}
			Statement statement = MySQLConn.createStatement();
			statement.execute(MySQLCmd);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			
		}
		return true;
	}
	/**
	 * 执行查询语句
	 * @param MySQLCmd 命令
	 * @return 查询返回对象
	 */
	public ArrayList<Object> execMySQLQuery(String MySQLCmd, DBObjectType type){
		System.out.println("MySQL exec:"+MySQLCmd);
		ArrayList<Object> result = new ArrayList<Object>();
		if(MySQLConn==null){
			System.out.println("connector is null");
			return null;
		}
		if(MySQLCmd.isEmpty()){
			System.out.println("cmd is empty");
			return null;
		}
		try{
			if(MySQLConn.isClosed()){
				System.out.println("connector is closed");
				return null;
			}
			Statement statement = MySQLConn.createStatement();
			ResultSet resultSet = statement.executeQuery(MySQLCmd);
			switch (type) {
			case TYPE_USER:
				
				while(resultSet.next()){
					User user = UserFactory.createUser();
					user.setUserName(resultSet.getString(UserTable_Name));
					user.setPassword(resultSet.getString(UserTable_Password));
					result.add(user);
				}
				break;
			case TYPE_PROBLEM:
				
				while(resultSet.next()){
					Problem problem = ProblemFactory.createProblem();
					problem.setID(resultSet.getInt(ProblemTable_ID));
					problem.setTitle(resultSet.getString(ProblemTable_Title));
					problem.setDescription(resultSet.getString(ProblemTable_Description));
					problem.setInputCase(resultSet.getString(ProblemTable_InputCase));
					problem.setOutputCase(resultSet.getString(ProblemTable_OutputCase));
					problem.setProposer(resultSet.getString(ProblemTable_Proposer));
					result.add(problem);
				}
				break;
			case TYPE_RECORD:
				
				while(resultSet.next()){
					Record record = RecordFactory.createRecord();
					record.setID(resultSet.getInt(RecordTable_ID));
					record.setUserName(resultSet.getString(RecordTable_Solver));
					record.setProblemID(resultSet.getInt(RecordTable_ProblemID));
					record.setResult(resultSet.getInt(RecordTable_Result));
					record.setTime(resultSet.getDate(RecordTable_Time).toString());
					result.add(record);
				}
				break;
			default:
				break;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			
		}
		return result;
	}
	/**
	 * 执行查询语句
	 * @param MySQLCmd 命令
	 * @return 查询返回对象
	 */
	public ArrayList<Object> execMySQLQuery(String MySQLCmd, String columnName){
		ArrayList<Object> result = new ArrayList<Object>();
		if(MySQLConn==null){
			System.out.println("connector is null");
			return null;
		}
		if(MySQLCmd.isEmpty()){
			System.out.println("cmd is empty");
			return null;
		}
		try{
			if(MySQLConn.isClosed()){
				System.out.println("connector is closed");
				return null;
			}
			Statement statement = MySQLConn.createStatement();
			ResultSet resultSet = statement.executeQuery(MySQLCmd);
			while(resultSet.next()){
				result.add(resultSet.getString(columnName));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			
		}
		return result;
	}
	/**
	 * 创建或修改数据对象
	 * @param object 对象
	 * @param type 对象类型
	 * @return 是否操作成功
	 */
	public boolean createOrModifyDBOject(Object object, DBObjectType type){
		ArrayList<Object> objectArray = new ArrayList<Object>();// 用于检查元组是否存在
		switch (type) {
		case TYPE_USER:
			objectArray = getDBObject(UserTable_Name, ((User)object).getUserName(), type);
			break;
		case TYPE_PROBLEM:
			objectArray = getDBObject(ProblemTable_ID, ((Problem)object).getID(), type);
			break;
		case TYPE_RECORD:
			objectArray = getDBObject(RecordTable_ID, ((Record)object).getID(), type);
			break;
		default:
			return false;
		}
		if(objectArray.isEmpty()){
			createDBObject(object, type);
		}else{
			// 直接删掉再新建一个
			switch (type) {
			case TYPE_USER:
				removeDBObject(UserTable_Name, ((User)object).getUserName(), type);
				break;
			case TYPE_PROBLEM:
				removeDBObject(ProblemTable_ID, ((Problem)object).getID(), type);
				break;
			case TYPE_RECORD:
				removeDBObject(RecordTable_ID, ((Record)object).getID(), type);
				break;
			default:
				return false;
			}
			createDBObject(object, type);
		}
		return true;
	}
}

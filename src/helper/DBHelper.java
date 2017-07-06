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
 * ���ݿ�����
 * @author ����
 *
 */
public class DBHelper {
	/**
	 * ���ݿ�������
	 */
	Connection MySQLConn;
	/* ���ݿ���ʲ���  */
	String DriverName;
	String URL;
	String UserName;
	String Password;
	String DatabaseName;
	String UserTable;
	String ProblemTable;
	String RecordTable;
	/* ������  */
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
	 * ���ݿ��������ö��
	 * @author ����
	 *
	 */
	public enum DBObjectType{
		TYPE_USER, TYPE_PROBLEM, TYPE_RECORD;
	}
	/**
	 * ���캯��
	 */
	public DBHelper(){
		initiatDBHelper();
	}
	/**
	 * ��ʼ�����ݿ�����
	 */
	protected void initiatDBHelper(){
		loadConfigure();
		connectDB();
	}
	/**
	 * �Ͽ�����
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
	 * ��������
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
	 * �������ݿ�
	 */
	protected void connectDB(){
		try{
			Class.forName(DriverName);// ������������
			System.out.println("load MySQL driver sucess!");
			System.out.println("log to mysql -h " + URL + " -u " + UserName + " -p " + Password);
			MySQLConn = DriverManager.getConnection(URL, UserName, Password);
			if(!MySQLConn.isClosed())System.out.println("sucess connect!");// �ж��Ƿ�ɹ�����
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
	 * �������ݿ��ַ
	 * @param URL ���ݿ��ַ
	 */
	public void setURL(String URL){this.URL=URL;}
	/**
	 * �������ݿ��¼�û���
	 * @param UserName ���ݿ��¼�û���
	 */
	public void setUserName(String UserName){this.UserName=UserName;}
	/**
	 * �������ݿ��¼����
	 * @param Password ���ݿ��¼����
	 */
	public void setPassword(String Password){this.Password=Password;}
	/**
	 * �������ݿ�����
	 * @param DatabaseName �������ݿ�����
	 */
	public void setDatabaseName(String DatabaseName){this.DatabaseName=DatabaseName;}
	/**
	 * �������ݿ����
	 * @param TableName ����
	 * @param type ���ݿ��������
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
	 * �����ݿ��и��ݶ������ʹ���Ԫ��
	 * @param object ����������
	 * @param type ���ݿ��������
	 * @return �Ƿ񴴽��ɹ�
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
	 * �����ݿ��и��ݶ��������޸�Ԫ��
	 * @param key ��
	 * @param keyValue ��ֵ
	 * @param type ��������
	 * @param modifyColumn ���޸ĵ��е�����
	 * @param modifyValue �µ�ֵ
	 * @return �Ƿ��޸ĳɹ�
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
	 * ��ȡ���ݿ����
	 * @param key ��
	 * @param keyValue ��ֵ
	 * @param type ��������
	 * @return ����
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
	 * �Ƴ����ݿ����
	 * @param key ��
	 * @param keyValue ��ֵ
	 * @param type ��������
	 * @return �Ƿ�����ɹ�
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
}

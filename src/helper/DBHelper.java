package helper;

import java.sql.*;
import java.sql.Connection;


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
		// undone
		return true;
	}
	/**
	 * �����ݿ��и��ݶ��������޸�Ԫ��
	 * @param key ����
	 * @param type ��������
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyDBOject(Object key, DBObjectType type){
		// undone
		return true;
	}
	/**
	 * ��ȡ���ݿ����
	 * @param key ����
	 * @param type ��������
	 * @return ����
	 */
	public Object getDBObject(Object key, DBObjectType type){
		// undone
		return true;
	}
	/**
	 * �Ƴ����ݿ����
	 * @param key ����
	 * @param type ��������
	 * @return �Ƿ�����ɹ�
	 */
	public boolean removeDBObject(Object key, DBObjectType type){
		// undone
		return true;
	}
}

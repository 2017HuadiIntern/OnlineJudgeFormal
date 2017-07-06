package helper;

import com.mysql.jdbc.Connection;

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
	String URL;
	String UserName;
	String Password;
	String DatabaseName;
	String UserTable;
	String ProblemTable;
	String RecordTable;
	/**
	 * ���ݿ��������ö��
	 * @author ����
	 *
	 */
	public enum DBObjectType{
		TYPE_USER, TYPE_PROBLEM, TYPE_RECORD;
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

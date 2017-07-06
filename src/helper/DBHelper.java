package helper;

import com.mysql.jdbc.Connection;

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
	String URL;
	String UserName;
	String Password;
	String DatabaseName;
	String UserTable;
	String ProblemTable;
	String RecordTable;
	/**
	 * 数据库对象类型枚举
	 * @author 屈彬
	 *
	 */
	public enum DBObjectType{
		TYPE_USER, TYPE_PROBLEM, TYPE_RECORD;
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

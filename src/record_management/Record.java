package record_management;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * 做题记录类
 * @author 屈彬
 *
 */
public class Record {
	int ID;
	String UserName;
	String ProblemID;
	boolean Result;
	String Time;
	public Record(){}
	/**
	 * 获取记录号
	 * @return 记录号
	 */
	public int getID(){return ID;}
	/**
	 * 设置记录号
	 * @param ID 记录号
	 */
	public void setID(int ID){this.ID=ID;}
	/**
	 * 获取做题人用户名
	 * @return 做题人用户名
	 */
	public String getUserName(){return UserName;}
	/**
	 * 设置做题人用户名
	 * @param UserName 做题人用户名
	 */
	public void setUserName(String UserName){this.UserName=UserName;}
	/**
	 * 获取题目编号
	 * @return 题目编号
	 */
	public String getProblemID(){return ProblemID;}
	/**
	 * 设置题目编号
	 * @param ProblemID 题目编号
	 */
	public void setProblemID(String ProblemID){this.ProblemID=ProblemID;}
}

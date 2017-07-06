package record_management;

/**
 * 做题记录类
 * @author 屈彬
 *
 */
public class Record {
	int ID;
	String UserName;
	int ProblemID;
	int Result;
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
	public int getProblemID(){return ProblemID;}
	/**
	 * 设置题目编号
	 * @param ProblemID 题目编号
	 */
	public void setProblemID(int ProblemID){this.ProblemID=ProblemID;}
	/**
	 * 获取结果
	 * @return 结果
	 */
	public int getResult(){return Result;}
	/**
	 * 设置结果
	 * @param Result 结果
	 */
	public void setResult(int Result){this.Result=Result;}
	/**
	 * 获取时间
	 * @return 时间
	 */
	public String getTime(){return Time;}
	/**
	 * 设置时间
	 * @param Time 时间
	 */
	public void setTime(String Time){this.Time=Time;}
}

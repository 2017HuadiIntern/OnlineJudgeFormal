package record_management;

/**
 * �����¼��
 * @author ����
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
	 * ��ȡ��¼��
	 * @return ��¼��
	 */
	public int getID(){return ID;}
	/**
	 * ���ü�¼��
	 * @param ID ��¼��
	 */
	public void setID(int ID){this.ID=ID;}
	/**
	 * ��ȡ�������û���
	 * @return �������û���
	 */
	public String getUserName(){return UserName;}
	/**
	 * �����������û���
	 * @param UserName �������û���
	 */
	public void setUserName(String UserName){this.UserName=UserName;}
	/**
	 * ��ȡ��Ŀ���
	 * @return ��Ŀ���
	 */
	public String getProblemID(){return ProblemID;}
	/**
	 * ������Ŀ���
	 * @param ProblemID ��Ŀ���
	 */
	public void setProblemID(String ProblemID){this.ProblemID=ProblemID;}
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public boolean getResult(){return Result;}
	/**
	 * ���ý��
	 * @param Result ���
	 */
	public void setResult(boolean Result){this.Result=Result;}
	/**
	 * ��ȡʱ��
	 * @return ʱ��
	 */
	public String getTime(){return Time;}
	/**
	 * ����ʱ��
	 * @param Time ʱ��
	 */
	public void setTime(String Time){this.Time=Time;}
}
package record_management;

/**
 * �����¼��
 * @author ����
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
	public int getProblemID(){return ProblemID;}
	/**
	 * ������Ŀ���
	 * @param ProblemID ��Ŀ���
	 */
	public void setProblemID(int ProblemID){this.ProblemID=ProblemID;}
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public int getResult(){return Result;}
	/**
	 * ���ý��
	 * @param Result ���
	 */
	public void setResult(int Result){this.Result=Result;}
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

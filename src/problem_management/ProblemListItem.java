package problem_management;
/**
 * ��Ŀ�б���
 * @author ����
 *
 */
public class ProblemListItem {
	int ID;
	String Title;
	String Proposer;
	/**
	 * ��ȡ��Ŀ���
	 * @return ��Ŀ���
	 */
	public int getID(){return ID;}
	/**
	 * ������Ŀ���
	 * @param ID ��Ŀ���
	 */
	public void setID(int ID){this.ID=ID;}
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public String getTitle(){return Title;}
	/**
	 * ���ñ���
	 * @param Title ����
	 */
	public void setTitle(String Title){this.Title=Title;}
	/**
	 * ��ȡ�������û���
	 * @return �������û���
	 */
	public String getProposer(){return Proposer;}
	/**
	 * ���ó������û���
	 * @param Proposer �������û���
	 */
	public void setProposer(String Proposer){this.Proposer=Proposer;}
}

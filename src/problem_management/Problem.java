package problem_management;
/**
 * ��Ŀ��
 * @author ����
 *
 */
public class Problem {
	int ID;
	String Title;
	String Description;
	String InputCase;
	String OutputCase;
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
	 * ��ȡ��Ŀ����
	 * @return ��Ŀ����
	 */
	public String getDescription(){return Description;}
	/**
	 * ������Ŀ����
	 * @param Description ��Ŀ����
	 */
	public void setDescription(String Description){this.Description=Description;}
	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getInputCase(){return InputCase;}
	/**
	 * ������������
	 * @param InputCase ��������
	 */
	public void setInputCase(String InputCase){this.InputCase=InputCase;}
	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public String getOutputCase(){return OutputCase;}
	/**
	 * �����������
	 * @param OutputCase
	 */
	public void setOutputCase(String OutputCase){this.OutputCase=OutputCase;}
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

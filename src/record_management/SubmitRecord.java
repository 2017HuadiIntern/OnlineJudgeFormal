package record_management;
/**
 * �ύ��������Ľ��-��������JSON
 * @author ����
 *
 */
public class SubmitRecord {
	/**
	 * ������
	 */
	int CaseID;
	/**
	 * ����������
	 * @param CaseID ������
	 */
	public void setCaseID(int CaseID){this.CaseID=CaseID;}
	/**
	 * ��ȡ������
	 * @return ������
	 */
	public int getCaseID(){return CaseID;}
	/**
	 * �����������Ϣ
	 */
	String CompileInfo;
	/**
	 * ���ñ��������Ϣ
	 * @param CompileInfo ���������Ϣ
	 */
	public void setCompileInfo(String CompileInfo){this.CompileInfo=CompileInfo;}
	/**
	 * ��ȡ������Ϣ
	 * @return ������Ϣ
	 */
	public String getCompileInfo(){return CompileInfo;}
	/**
	 * ִ����Ϣ
	 */
	String ExecInfo;
	/**
	 * ����ִ����Ϣ
	 * @param ExecInfo ִ����Ϣ
	 */
	public void setExecInfo(String ExecInfo){this.ExecInfo = ExecInfo;}
	/**
	 * ��ȡִ����Ϣ
	 * @return ִ����Ϣ
	 */
	public String getExecInfo(){return ExecInfo;}
}

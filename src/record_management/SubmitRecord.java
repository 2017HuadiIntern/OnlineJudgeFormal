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
	/**
	 * ��������
	 */
	String InputCase;
	/**
	 * ������������
	 * @param InputCase
	 */
	public void setInputCase(String InputCase){this.InputCase=InputCase;}
	/**
	 * ��ȡ�������
	 * @return
	 */
	public String getInputCase(){return InputCase;}
	/**
	 * �������
	 */
	String OutputCase;
	/**
	 * �����������
	 * @param OutputCase
	 */
	public void setOutputCase(String OutputCase){this.OutputCase=OutputCase;}
	/**
	 * ��ȡ�������
	 * @return
	 */
	public String getOutputCase(){return OutputCase;}
}

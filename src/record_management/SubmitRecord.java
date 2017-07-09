package record_management;
/**
 * 提交代码后反馈的结果-用于生成JSON
 * @author 屈彬
 *
 */
public class SubmitRecord {
	/**
	 * 用例号
	 */
	int CaseID;
	/**
	 * 设置用例号
	 * @param CaseID 用例号
	 */
	public void setCaseID(int CaseID){this.CaseID=CaseID;}
	/**
	 * 获取用例号
	 * @return 用例号
	 */
	public int getCaseID(){return CaseID;}
	/**
	 * 编译器输出信息
	 */
	String CompileInfo;
	/**
	 * 设置编译输出信息
	 * @param CompileInfo 编译输出信息
	 */
	public void setCompileInfo(String CompileInfo){this.CompileInfo=CompileInfo;}
	/**
	 * 获取编译信息
	 * @return 编译信息
	 */
	public String getCompileInfo(){return CompileInfo;}
	/**
	 * 执行信息
	 */
	String ExecInfo;
	/**
	 * 设置执行信息
	 * @param ExecInfo 执行信息
	 */
	public void setExecInfo(String ExecInfo){this.ExecInfo = ExecInfo;}
	/**
	 * 获取执行信息
	 * @return 执行信息
	 */
	public String getExecInfo(){return ExecInfo;}
	/**
	 * 输入用例
	 */
	String InputCase;
	/**
	 * 设置输入用例
	 * @param InputCase
	 */
	public void setInputCase(String InputCase){this.InputCase=InputCase;}
	/**
	 * 获取输出用例
	 * @return
	 */
	public String getInputCase(){return InputCase;}
	/**
	 * 输出用例
	 */
	String OutputCase;
	/**
	 * 设置输出用例
	 * @param OutputCase
	 */
	public void setOutputCase(String OutputCase){this.OutputCase=OutputCase;}
	/**
	 * 获取输出用例
	 * @return
	 */
	public String getOutputCase(){return OutputCase;}
}

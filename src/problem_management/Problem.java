package problem_management;
/**
 * 题目类
 * @author 屈彬
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
	 * 获取题目编号
	 * @return 题目编号
	 */
	public int getID(){return ID;}
	/**
	 * 设置题目编号
	 * @param ID 题目编号
	 */
	public void setID(int ID){this.ID=ID;}
	/**
	 * 获取题目描述
	 * @return 题目描述
	 */
	public String getDescription(){return Description;}
	/**
	 * 设置题目描述
	 * @param Description 题目描述
	 */
	public void setDescription(String Description){this.Description=Description;}
	/**
	 * 获取输入用例
	 * @return 输入用例
	 */
	public String getInputCase(){return InputCase;}
	/**
	 * 设置输入用例
	 * @param InputCase 输入用例
	 */
	public void setInputCase(String InputCase){this.InputCase=InputCase;}
	/**
	 * 获取输出用例
	 * @return 输出用例
	 */
	public String getOutputCase(){return OutputCase;}
	/**
	 * 设置输出用例
	 * @param OutputCase
	 */
	public void setOutputCase(String OutputCase){this.OutputCase=OutputCase;}
	/**
	 * 获取出题人用户名
	 * @return 出题人用户名
	 */
	public String getProposer(){return Proposer;}
	/**
	 * 设置出题人用户名
	 * @param Proposer 出题人用户名
	 */
	public void setProposer(String Proposer){this.Proposer=Proposer;}
}

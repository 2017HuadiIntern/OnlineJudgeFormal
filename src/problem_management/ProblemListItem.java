package problem_management;
/**
 * 题目列表项
 * @author 屈彬
 *
 */
public class ProblemListItem {
	int ID;
	String Title;
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
	 * 获取标题
	 * @return 标题
	 */
	public String getTitle(){return Title;}
	/**
	 * 设置标题
	 * @param Title 标题
	 */
	public void setTitle(String Title){this.Title=Title;}
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

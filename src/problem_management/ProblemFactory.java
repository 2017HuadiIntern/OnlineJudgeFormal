package problem_management;
/**
 * 题目工厂
 * @author 屈彬
 *
 */
public class ProblemFactory {
	/**
	 * 创建题目
	 * @return 题目
	 */
	public static Problem createProblem(){
		return new Problem();
	}
	/**
	 * 创建题目列表项
	 */
	public static ProblemListItem createProblemListItem(){
		return new ProblemListItem();
	}
	/**
	 * 创建题目列表
	 * @return 题目列表
	 */
	public static ProblemList createProblemList(){
		return new ProblemList();
	}
}

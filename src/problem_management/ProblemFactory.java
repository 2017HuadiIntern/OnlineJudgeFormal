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
}

package problem_management;
/**
 * ��Ŀ����
 * @author ����
 *
 */
public class ProblemFactory {
	/**
	 * ������Ŀ
	 * @return ��Ŀ
	 */
	public static Problem createProblem(){
		return new Problem();
	}
	/**
	 * ������Ŀ�б���
	 */
	public static ProblemListItem createProblemListItem(){
		return new ProblemListItem();
	}
	/**
	 * ������Ŀ�б�
	 * @return ��Ŀ�б�
	 */
	public static ProblemList createProblemList(){
		return new ProblemList();
	}
}

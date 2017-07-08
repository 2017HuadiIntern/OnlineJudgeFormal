package problem_management;
/**
 * 题目列表，用于向列表页面传值
 * @author 屈彬
 *
 */

import java.util.ArrayList;

public class ProblemList {
	/**
	 * 题目项列表
	 */
	ArrayList<ProblemListItem> MainList;
	/**
	 * 添加项目
	 * @param item
	 */
	public void addItem(ProblemListItem item){MainList.add(item);}
	/**
	 * 获取主列表
	 * @return 主列表
	 */
	public ArrayList<ProblemListItem> getMainList(){return MainList;}
	public ProblemList(){
		MainList = new ArrayList<ProblemListItem>();
	}
}

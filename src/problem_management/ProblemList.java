package problem_management;
/**
 * ��Ŀ�б��������б�ҳ�洫ֵ
 * @author ����
 *
 */

import java.util.ArrayList;

public class ProblemList {
	/**
	 * ��Ŀ���б�
	 */
	ArrayList<ProblemListItem> MainList;
	/**
	 * �����Ŀ
	 * @param item
	 */
	public void addItem(ProblemListItem item){MainList.add(item);}
	/**
	 * ��ȡ���б�
	 * @return ���б�
	 */
	public ArrayList<ProblemListItem> getMainList(){return MainList;}
	public ProblemList(){
		MainList = new ArrayList<ProblemListItem>();
	}
}

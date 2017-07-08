package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ�������
 * @author ����
 *
 */
public class StringHelper {
	/**
	 * �ж��ַ������Ƿ��������
	 * @param str �����ַ���
	 * @return �жϽ��
	 */
	public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
	/**
     * �ж��Ƿ��������ַ�
     *
     * @param str
     * @return trueΪ������falseΪ������
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~��@#��%����&*��������+|{}������������������������]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}

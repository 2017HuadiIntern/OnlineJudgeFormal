package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ×Ö·û´®ÖúÊÖ
 * @author Çü±ò
 *
 */
public class StringHelper {
	/**
	 * ÅĞ¶Ï×Ö·û´®ÖĞÊÇ·ñ°üº¬ÖĞÎÄ
	 * @param str ÊäÈë×Ö·û´®
	 * @return ÅĞ¶Ï½á¹û
	 */
	public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}

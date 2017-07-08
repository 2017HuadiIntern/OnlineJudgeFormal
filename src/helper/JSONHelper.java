package helper;



import net.sf.json.*;

/**
 * JSON��������
 * @author ����
 *
 */
public class JSONHelper {
	/**
	 * ������ת��ΪJSON�ַ���
	 * @param object ����
	 * @return JSON�ַ���
	 */
	public static String JSONSerialize(Object object){
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}
	/**
	 * JSON�ַ���ת��Ϊ����
	 * @param JSONserial JSON�ַ���
	 * @param key ��
	 * @return ����
	 */
	public static Object JSONDeserialize(String JSONserial, Class c){
		JSONObject jsonObject = JSONObject.fromObject(JSONserial);
		return JSONObject.toBean(jsonObject, c);
	}
}


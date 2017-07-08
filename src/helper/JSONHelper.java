package helper;



import net.sf.json.*;

/**
 * JSON报文助手
 * @author 屈彬
 *
 */
public class JSONHelper {
	/**
	 * 将对象转换为JSON字符串
	 * @param object 对象
	 * @return JSON字符串
	 */
	public static String JSONSerialize(Object object){
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}
	/**
	 * JSON字符串转换为对象
	 * @param JSONserial JSON字符串
	 * @param key 键
	 * @return 对象
	 */
	public static Object JSONDeserialize(String JSONserial, Class c){
		JSONObject jsonObject = JSONObject.fromObject(JSONserial);
		return JSONObject.toBean(jsonObject, c);
	}
}


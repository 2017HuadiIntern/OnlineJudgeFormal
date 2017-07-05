package helper;
/**
 * 配置助手
 * @author 屈彬
 *
 */

import java.util.HashMap;

public class ConfHelper {
	/**
	 * 配置文件路径
	 */
	protected final String CONF_FILE_PATH = "/conf/OJConfigure.xml";// undone
	/**
	 * 配置属性哈希表
	 */
	protected HashMap<String, String> ValueHash;
	/**
	 * 构造函数
	 */
	public ConfHelper(){
		initiateConf();
	}
	/**
	 * 初始化配置助手
	 */
	protected void initiateConf(){
		// undone
	}
	/**
	 * 获取配置属性值
	 * @param key 属性名
	 * @exception 未知属性键异常
	 * @return 属性值
	 */
	public String getConfValue(String key) throws Exception{
		if(!ValueHash.containsKey(key))throw new Exception("unknown key!");
		return ValueHash.get(key);
	}
}

package helper;
/**
 * ��������
 * @author ����
 *
 */

import java.util.HashMap;

public class ConfHelper {
	/**
	 * �����ļ�·��
	 */
	protected final String CONF_FILE_PATH = "/conf/OJConfigure.xml";// undone
	/**
	 * �������Թ�ϣ��
	 */
	protected HashMap<String, String> ValueHash;
	/**
	 * ���캯��
	 */
	public ConfHelper(){
		initiateConf();
	}
	/**
	 * ��ʼ����������
	 */
	protected void initiateConf(){
		// undone
	}
	/**
	 * ��ȡ��������ֵ
	 * @param key ������
	 * @exception δ֪���Լ��쳣
	 * @return ����ֵ
	 */
	public String getConfValue(String key) throws Exception{
		if(!ValueHash.containsKey(key))throw new Exception("unknown key!");
		return ValueHash.get(key);
	}
}

package helper;
/**
 * 配置助手
 * @author 屈彬
 *
 */

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ConfHelper {
	/* Session所使用名称 */
	public static final String SESSION_USER_NAME="UserName";
	/* HTTP请求所使用名称 */
	public static final String REQUEST_USER_NAME="username";
	public static final String REQUEST_LOGIN_PASSWORD="password";
	public static final String REQUEST_REGISTER_PASSWORD="password1";
	public static final String REQUEST_CONFIRM_PASSWORD="password2";
	
	public static final String REQUEST_PROBLEM_TITLE="problem_title";
	public static final String REQUEST_PROBLEM_DESCRIPTION="problem_description";
	public static final String REQUEST_PROBLEM_INPUT_CASE="problem_input_case";
	public static final String REQUEST_PROBLEM_OUTPUT_CASE="problem_output_case";
	/**
	 * 配置文件路径
	 */
	protected String CONF_FILE_PATH = "/conf/OJConfigure.xml";// undone
	/**
	 * 配置文件相对路径
	 */
	public static final String CONF_FILE_RELATED_PATH = "/conf/OJConfigure.xml";
	/**
	 * 获取配置文件路径
	 * @return 配置文件路径
	 */
	public String getConfFilePath(){return CONF_FILE_PATH;}
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
	/* 带参数的配置文件路径 */
	public ConfHelper(String conf_file_path){
		CONF_FILE_PATH = conf_file_path;
		initiateConf();
	}
	/**
	 * 初始化配置助手
	 */
	protected void initiateConf(){
		ValueHash = new HashMap<String, String>();
		// 读取XML配置文件
		SAXReader sax_reader = new SAXReader();
		File xmlFile = new File(CONF_FILE_PATH);
		try {
			Document document = sax_reader.read(xmlFile);
			Element root = document.getRootElement();
			getNodes(root);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}
		// undone
	}
	/**
	 * 从指定节点开始,递归遍历所有子节点
	 * @author chenleixing
	 */
	protected void getNodes(Element node){
		System.out.println("--------------------");
		
		//当前节点的名称、文本内容和属性
		System.out.println("当前节点名称："+node.getName());//当前节点名称
		System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称
		ValueHash.put(node.getName(), node.getTextTrim());
		List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
		for(Attribute attr:listAttr){//遍历当前节点的所有属性
			String name=attr.getName();//属性名称
			String value=attr.getValue();//属性的值
			
		}
		
		//递归遍历当前节点所有的子节点
		List<Element> listElement=node.elements();//所有一级子节点的list
		for(Element e:listElement){//遍历所有一级子节点
			this.getNodes(e);//递归
		}
	}
	/**
	 * 获取配置属性值
	 * @param key 属性名
	 * @exception 未知属性键异常
	 * @return 属性值
	 */
	public String getConfValue(String key) {
		return ValueHash.get(key);
	}
	
}

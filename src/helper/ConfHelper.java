package helper;
/**
 * ��������
 * @author ����
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
	/* Session��ʹ������ */
	public static final String SESSION_USER_NAME="UserName";
	/* HTTP������ʹ������ */
	public static final String REQUEST_USER_NAME="username";
	public static final String REQUEST_LOGIN_PASSWORD="password";
	public static final String REQUEST_REGISTER_PASSWORD="password1";
	public static final String REQUEST_CONFIRM_PASSWORD="password2";
	
	public static final String REQUEST_PROBLEM_TITLE="problem_title";
	public static final String REQUEST_PROBLEM_DESCRIPTION="problem_description";
	public static final String REQUEST_PROBLEM_INPUT_CASE="problem_input_case";
	public static final String REQUEST_PROBLEM_OUTPUT_CASE="problem_output_case";
	/**
	 * �����ļ�·��
	 */
	protected String CONF_FILE_PATH = "/conf/OJConfigure.xml";// undone
	/**
	 * �����ļ����·��
	 */
	public static final String CONF_FILE_RELATED_PATH = "/conf/OJConfigure.xml";
	/**
	 * ��ȡ�����ļ�·��
	 * @return �����ļ�·��
	 */
	public String getConfFilePath(){return CONF_FILE_PATH;}
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
	/* �������������ļ�·�� */
	public ConfHelper(String conf_file_path){
		CONF_FILE_PATH = conf_file_path;
		initiateConf();
	}
	/**
	 * ��ʼ����������
	 */
	protected void initiateConf(){
		ValueHash = new HashMap<String, String>();
		// ��ȡXML�����ļ�
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
	 * ��ָ���ڵ㿪ʼ,�ݹ���������ӽڵ�
	 * @author chenleixing
	 */
	protected void getNodes(Element node){
		System.out.println("--------------------");
		
		//��ǰ�ڵ�����ơ��ı����ݺ�����
		System.out.println("��ǰ�ڵ����ƣ�"+node.getName());//��ǰ�ڵ�����
		System.out.println("��ǰ�ڵ�����ݣ�"+node.getTextTrim());//��ǰ�ڵ�����
		ValueHash.put(node.getName(), node.getTextTrim());
		List<Attribute> listAttr=node.attributes();//��ǰ�ڵ���������Ե�list
		for(Attribute attr:listAttr){//������ǰ�ڵ����������
			String name=attr.getName();//��������
			String value=attr.getValue();//���Ե�ֵ
			
		}
		
		//�ݹ������ǰ�ڵ����е��ӽڵ�
		List<Element> listElement=node.elements();//����һ���ӽڵ��list
		for(Element e:listElement){//��������һ���ӽڵ�
			this.getNodes(e);//�ݹ�
		}
	}
	/**
	 * ��ȡ��������ֵ
	 * @param key ������
	 * @exception δ֪���Լ��쳣
	 * @return ����ֵ
	 */
	public String getConfValue(String key) {
		return ValueHash.get(key);
	}
	
}

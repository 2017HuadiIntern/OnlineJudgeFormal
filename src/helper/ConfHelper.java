package helper;
/**
 * ��������
 * @author ����
 *
 */

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


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
		List<Attribute> listAttr=node.attributes();//��ǰ�ڵ���������Ե�list
		for(Attribute attr:listAttr){//������ǰ�ڵ����������
			String name=attr.getName();//��������
			String value=attr.getValue();//���Ե�ֵ
			System.out.println("�������ƣ�"+name+"����ֵ��"+value);
			ValueHash.put(name, value);
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
	public String getConfValue(String key) throws Exception{
		if(!ValueHash.containsKey(key))throw new Exception("unknown key!");
		return ValueHash.get(key);
	}
	
}

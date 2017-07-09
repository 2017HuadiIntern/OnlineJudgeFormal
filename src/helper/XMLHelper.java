package helper;
/**
 * XML�ļ�����
 * @author ����
 *
 */

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLHelper {
	/**
	 * ��XML�л�ȡֵ
	 * @return
	 */
public static HashMap<String, String> getDataFromXML(String xmlStr){
	System.out.println("caseXML:"+xmlStr);
	HashMap<String, String> ValueHash = new HashMap<String, String>();
	// ��ȡXML�����ļ�
	SAXReader sax_reader = new SAXReader();
	try {
		Document document = sax_reader.read(new ByteArrayInputStream(xmlStr.getBytes()));
		Element root = document.getRootElement();
		//�ݹ������ǰ�ڵ����е��ӽڵ�
				List<Element> listElement=root.elements();//����һ���ӽڵ��list
				for(Element e:listElement){//��������һ���ӽڵ�
					String name=e.getName();
					String value=e.getStringValue();
					ValueHash.put(name, value);
				}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		
	}
	return ValueHash;
}
}

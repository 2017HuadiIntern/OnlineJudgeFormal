package helper;
/**
 * XML文件助手
 * @author 屈彬
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
	 * 从XML中获取值
	 * @return
	 */
public static HashMap<String, String> getDataFromXML(String xmlStr){
	System.out.println("caseXML:"+xmlStr);
	HashMap<String, String> ValueHash = new HashMap<String, String>();
	// 读取XML配置文件
	SAXReader sax_reader = new SAXReader();
	try {
		Document document = sax_reader.read(new ByteArrayInputStream(xmlStr.getBytes()));
		Element root = document.getRootElement();
		//递归遍历当前节点所有的子节点
				List<Element> listElement=root.elements();//所有一级子节点的list
				for(Element e:listElement){//遍历所有一级子节点
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

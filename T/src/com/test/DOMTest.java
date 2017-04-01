package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.*; 
public class DOMTest {

	private String outFile="e:\\people.xml";
	
	public static void main(String[] args) throws Exception {
		new DOMTest();
	}
	
	public DOMTest() throws Exception{
		DocumentBuilder builder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc=builder.newDocument();
		Element root=doc.createElement("老师");
		Element wang=doc.createElement("王");
		Element liu=doc.createElement("刘");
		wang.appendChild(doc.createTextNode("我是王老师"));
		root.appendChild(wang);
		doc.appendChild(root);
		
		Transformer transformer=TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING,"gb2312");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(doc), new StreamResult(outFile));
		
		
	}
}

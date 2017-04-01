package com.test;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
public class SAXHandler extends HandlerBase {

	private Hashtable table=new Hashtable();
	private String currentElement=null;
	private String currentValue=null;
	public Hashtable getTable() {
		return table;
	}
	public void setTable(Hashtable table) {
		this.table = table;
	}
	
	
	@Override
	public void startElement(String tag, AttributeList attributes)
			throws SAXException {
		currentElement=tag;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		currentValue=new String(ch,start,length);
	}
	@Override
	public void endElement(String name) throws SAXException {
		if(currentElement.equals(name))
		table.put(currentElement, currentValue);
	}
	
	
	public static void main(String[] args) {
		
		
	}
	
}

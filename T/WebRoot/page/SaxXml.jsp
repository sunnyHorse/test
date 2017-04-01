<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.io.* "%>
<%@ page import="java.util.Hashtable "%> 
<%@ page import="org.w3c.dom.*" %> 
<%@ page import="org.xml.sax.*" %> 
<%@ page import="javax.xml.parsers.SAXParserFactory" %> 
<%@  page import="javax.xml.parsers.SAXParser" %> 
<%@  page import="com.test.SAXHandler "%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>剖析XML文件people.xml</title>
</head>
<body>
<%
		File file=new File("e:\\teacher.xml");
		FileReader reader=new FileReader(file);
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		SAXHandler saxHandler=new SAXHandler();
		sp.parse(new InputSource(reader), saxHandler);
		Hashtable hashTable=saxHandler.getTable();
		out.println("<table border='2'><caption>教师信息表</caption>");
		out.println("<tr><td>姓名</td><td>"+(String)hashTable.get("name")+"</td></tr>");
		out.println("<tr><td>学院</td><td>"+(String)hashTable.get("college")+"</td></tr>");
		out.println("<tr><td>电话</td><td>"+(String)hashTable.get("telephone")+"</td></tr>");
		out.println("<tr><td>备注</td><td>"+(String)hashTable.get("notes")+"</td></tr>");
		out.println("</table>");

 %>
</body>
</html>
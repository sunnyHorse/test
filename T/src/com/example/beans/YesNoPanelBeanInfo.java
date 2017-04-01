package com.example.beans;

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class YesNoPanelBeanInfo extends SimpleBeanInfo{

	/**
	 * Return an icon for the bean .We should really check the kind argument
	 * to see what size icon the beanbox wants,but since we only have one 
	 * icon to offer,we just return it and let the beanbox deal with it
	 */
	public Image getIcon(int kind){	return loadImage("YesNoPanelIcon.gif");}
	
	public BeanDescriptor getBeanDescriptor(){
		return new BeanDescriptor(YesNoPanel.class,YesNoPanelCustomeizer.class);
	}
	
	/**This is a convenience method for creating PropertyDescriptor objects */
	static PropertyDescriptor prop(String name,String description){
		try {
				PropertyDescriptor p=new PropertyDescriptor(name,YesNoPanel.class);
				p.setShortDescription(description);
				return p;
		} 
		catch (IntrospectionException e) {return null;}
	}
	
	//Initialize a static array of PropertyDescriptor objects that provide
	//additional information about the properties supported by the bean
	//By explicitly specifying property descriptors,we are able to provide
	//simple help strings for each property;these would not available to 
	//the beanbox through simple introspection.We are also able to register
	//a special property editors for the messageText property
	static PropertyDescriptor [] props={
		prop("messageText", "The message text that appears in the bean body"),
		prop("alignment", "The alignment of the message text"),
		prop("yesLabel", "The label for the Yes button"),
		prop("noLabel", "The label for the No button"),
		prop("cancelLabel","The label for the Cancel button"),
		prop("font", "The font for the message and buttons"),
		prop("background", "The background color"),
		prop("foreground", "The foreground color"),
	};
	
	static {
		props[0].setPropertyEditorClass(YesNoPanelMessageEditor.class);
		}
	
	/**Return the property descriptors for this bean*/
	public PropertyDescriptor[] getPropertyDescrtiors(){	return props;}
	
	/**The message property is most often customized ;make it the default */
	public int getDefaultPropertyIndex(){	return 0;}
	
	
}

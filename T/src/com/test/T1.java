package com.test;

import java.util.Arrays;
import java.util.StringTokenizer;

public class T1 {

	public static void main(String[] args) {
		String orgStr="a,b,c,ff,df,sds,s,d";
		StringTokenizer  tokener = new StringTokenizer(orgStr,","); 
		String [] result = new String[tokener .countTokens()];
		int i=0;
	
		while(tokener.hasMoreTokens()){
			result [i++]=tokener.nextToken();
			}
		
		System.out.println(Arrays.toString(result));
	}

}

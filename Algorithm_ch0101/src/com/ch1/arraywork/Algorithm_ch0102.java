package com.ch1.arraywork;

public class Algorithm_ch0102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcba";
		String S2="acbab";
		//System.out.println(transferArray(s1));
		
	}
	public static boolean checkStr(String str1,String str2)
	{
		//save to Array
		String[] strArray1 = transferArray(str1);
		String[] strArray2 = transferArray(str2);
		
		
		
		return true;
	}
	public static String[] transferArray(String s)
	{
		String[] items = new String[s.length()];
		String[] results = new String[items.length];
		  for (int i = 0; i < items.length; i++) {
			  items[i] = s.substring(i,i+1);
			  // System.out.println( items[i]);
		  }
		return items;
	}

}

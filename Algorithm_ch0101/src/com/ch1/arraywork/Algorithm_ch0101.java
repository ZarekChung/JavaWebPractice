package com.ch1.arraywork;


public class Algorithm_ch0101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String checkStr = "_a456_";
		System.out.println(checkString(checkStr));
	}
	
	public static boolean checkString(String s)
	{
		boolean result=true;
		if(!s.equals(""))
		{
			for(int i=0;i<s.length();i++)
			{
				char tempS = s.charAt(i);	
				for(int j=0;j<s.length();j++){
					if(s.charAt(j)==tempS && i!=j)
					{
						result =  false;
					}
				}
			}
		}
		else
		{
			result = true;
		}
		return result;
	}

}

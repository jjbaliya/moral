package demo;

public class HelloWorldConvert {

	public static void reverseString (String str){ 
	    if (str.length() == 1){ 
	      System.out.print(str); 
	    } 
	    else{ 
	      String subString1 = str.substring(0, str.length()-1);
	      String subString2 = str.substring(str.length()-1); 
	       
	      System.out.print(subString2); 
	       
	      reverseString (subString1);      
	    } 
	  } 

	
	public static void main(String[] args) {
		
		//1、Stringbuffer.reverse();
		//String a = "hello";
		//StringBuffer sb = new StringBuffer(a);
		//System.out.println(sb.reverse());
		
		reverseString ("hello");
		
	}
}

package demo;

public class WordsReversion {

	public static void main(String[] args) {

		WordsReversion("hello world");
	}

	private static void WordsReversion(String str) {
		if (str.length() == 1) {
			System.out.print(str);
		} else {
			String str1 = str.substring(0, str.length() - 1);
			// 输出最后的值;
			String str2 = str.substring(str.length() - 1);
			System.out.print(str2);

			WordsReversion(str1);
		}

	}
}

/*
 * if(str.length() == 1){ System.out.println(str); }else{ String str1 =
 * str.substring(0, str.length()-1); //截取最后一个字母; String str2 =
 * str.substring(str.length()-1); System.out.print(str2); WordsReversion(str1);
 * }
 */
package sec11.ex01;

public class ReplaceTrimEx {

	public static void main(String[] args) {
	      // replace: 문자열 내에서 특정 문자 또는 문자열을 치환
	      String text = "Hello, World!";
	      String replacedText = text.replace("World", "Java");
	      System.out.println("치환된 문자열: " + replacedText);
	      
	      // trim: 문자열 앞뒤의 공백을 제거
	      String trimText = "   Hello, World      !     ";
	      String trimmedText = trimText.trim();
	      System.out.println("공백 제거된 문자열: " + trimmedText);
	}

}

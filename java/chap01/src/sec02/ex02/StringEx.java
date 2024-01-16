package sec02.ex02;

public class StringEx {

	public static void main(String[] args) {
		// 주의해야 합니다
		// char ch1 = "A"; char로 선언하면 작은따옴표로 지정해줘야 합니다.
		// char ch2 = 'Hello'; char로 선언하면 한글자만 입력할 수 있습니다.
		String greeting = "Hello World";
		System.out.println(greeting);
		
		// escape 문자열
		String str1 = "문자열 안에 \"이스케이프 문자\"를 사용하여 식별기호를 표시할 수 있습니다";
		System.out.println(str1);
		String str2 = "이것은 \n 새 줄입니다.";
		String str3 = "이것은 \t 탭입니다.";
		System.out.println(str2);
		System.out.println(str3);
	}

}

package sec11.ex01;

public class LowerUpperEx {

	public static void main(String[] args) {
		   String original = "Hello, World!";
	        
	        // 소문자로 변환
	        String lower = original.toLowerCase();
	        
	        // 대문자로 변환
	        String upper = original.toUpperCase();
	        
	        // 변환된 문자열 출력
	        System.out.println(lower); // "hello, world!"
	        System.out.println(upper); // "HELLO, WORLD!"
	}

}

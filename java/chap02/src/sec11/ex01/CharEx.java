package sec11.ex01;

public class CharEx {

	public static void main(String[] args) {
		// 1. 문자열 순회
		String str = "Hello, World!";
		System.out.print("1. ");
		for (int i = 0; i < str.length(); i++) {
			char c1 = str.charAt(i); // char은 기본타입, string은 참조타입이므로 다운캐스팅 같은거 못함
			System.out.print(c1);
		}
		System.out.println("");
		
		// 2. 특정 인덱스 문자 검사
		char c2 = str.charAt(7);
		if (c2 == 'W') {
			System.out.println("2. 문자 W가 존재합니다.");
		} else {
			System.out.println("2. 문자 W가 존재하지 않습니다.");
		}
		
		// 3. 문자열 역순 출력
		System.out.print("3. ");
		for (int i = str.length() - 1; i >= 0; i--) {
			char c3 = str.charAt(i);
			System.out.print(c3);
		}
		System.out.println("");
		
		// 4. 특정 문자 개수 세기
		char targetChar = 'l';
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == targetChar) {
				count++;
			}
		}
		System.out.println("4. 문자 'l'의 개수: " + count);
	}

}

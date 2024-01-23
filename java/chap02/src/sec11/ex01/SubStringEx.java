package sec11.ex01;

public class SubStringEx {

	public static void main(String[] args) {
        // substring: 문자열에서 특정 부분을 잘라내어 새로운 문자열을 반환하는 메서드
		String originalString = "Hello, World!";
        
        // 부분 문자열 추출
        String substring1 = originalString.substring(7); // 시작만 쓰면 뒤에 있는거 싹 다 - 인덱스 7번부터 끝까지 추출
        String substring2 = originalString.substring(0, 5); // 인덱스 0번부터 5번까지 추출
        
        // 추출한 부분 문자열 출력
        System.out.println(substring1);
        System.out.println(substring2);
	}

}

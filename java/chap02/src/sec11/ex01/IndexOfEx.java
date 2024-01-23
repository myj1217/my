package sec11.ex01;

public class IndexOfEx {

	public static void main(String[] args) {
		String sentence = "Java is a programming language, Java is fun";
		String word = "Java";
		int index = sentence.indexOf(word);
		
		// 1. 단어가 있는지 확인
		if (index != -1) {
			System.out.println("문자열에 단어 '" + word + "'가 존재합니다.");
		} else {
			System.out.println("문자열에 단어 '" + word + "'가 존재하지 않습니다.");
		}
		
		// 2. 'Java' 단어가 시작되는 모든 인덱스 번호 찾기
		while (index != -1) {
			System.out.println("'" + word + "'의 등장 위치: " + index);
			index = sentence.indexOf(word, index + 1);
		}
		
		// 3. 첫번째 문자 인덱스 찾기
		String sentence3 = "Hello, World!";
		char targetChar3 = 'o';
		int index3 = sentence3.indexOf(targetChar3);
		System.out.println("'" + targetChar3 + "'의 첫번째 등장 위치: " + index3);
	}

}

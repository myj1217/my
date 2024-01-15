package sec02.ex02;

public class Characters {

	public static void main(String[] args) {
		// 유니코드 값 65는 'A'
		char ch01 = 65;
		System.out.println(ch01);
		
		char ch02 = '\u0041';
		System.out.println(ch02);
		
		// 'A'에 해당하는 유니코드 값(65)이 저장
		char ch03 = 'A'; //65
		int num = 10;
		int result = ch03 + num; //75	
		System.out.println(result); 
	}

}

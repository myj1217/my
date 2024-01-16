package sec02.ex03;

public class TypeCastingEx {

	public static void main(String[] args) {
		char ch01 = 'A';
		char ch02 = 1;
		// char ch03 = ch01 + ch02; 에러
		// 연산을 해주고 싶다면 숫자로 바꿔야한다.
		int int1 = ch01 + ch02;  // 65 + 1
		System.out.println((char)int1);  // 'B'값을 보고싶다.
		
		int x = 1;
		int y = 2;
		double result1 = (double) x / (double) y;
		double result2 = x / y;  // 몫이 0
		// int인 상태에서 소수점 연산을 해봐야 안나옴
		System.out.println(result1);
		System.out.println(result2);
	}

}

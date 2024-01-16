package sec03.ex01;

public class BitOperation {

	public static void main(String[] args) {
		int a = 5; // 이진 표현: 00000101
		int b = 3; // 이진 표현: 00000011
		
		// 비트 AND 연산
		int result1 = a & b; // 결과: 00000001 (1)
		
		// 비트 OR 연산
		int result2 = a | b; // 결과: 00000111 (7)
		
		// 비트 XOR 연산
		int result3 = a ^ b; // 결과: 00000110 (6)
		
		// 비트 NOT 연산
		int result4 = ~a; // 결과: 11111010 (-6)
		
		// 왼쪽 시프트 연산
		int result5 = a << 2; // 결과: 00010100 (20)
		
		// 오른쪽 시프트 연산
		int result6 = a >> 1; // 결과: 00000010 (2)
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
	}

}

package sec02.ex02;

public class DefaultNumber {

	public static void main(String[] args) {
		// byte 타입: -128~127 까지의 정수를 저장할 수 있습니다.
		byte myNum1 = 127;
		System.out.println(myNum1);
		
		// short 타입: -32768~32767 까지의 정수를 저장할 수 있습니다.
		short myNum2 = 32767;
		System.out.println(myNum2);
		
		// int 타입: -2147483648~2147483647 까지의 정수를 저장할 수 있습니다.
		// 자바는 기본 정수형을 int 타입으로 해석합니다.
		int myNum3 = 2147483647;
		System.out.println(myNum3);
		
		// long 타입: -9223372036854775808~9223372036854775807 까지의 정수를 저장할 수 있습니다.
		// 값은 "L"로 끝나야 합니다.
		long myNum4 = 9223372036854775807L;
		System.out.println(myNum4);
	}

}

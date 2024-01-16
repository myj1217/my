package sec03.ex01;

public class Allotment {

	public static void main(String[] args) {
		int a = 5;
		
		// 값 할당
		int b = a; // b에 a의 값인 5를 할당
		
		// 덧셈 후 할당
		int c = 10;
		c += a; // c에 c와 a를 더한 값(15)을 할당
		
		// 뺄셈 후 할당
		int d = 8;
		d -= a; // d에서 a를 뺀 값(3)을 할당
		
		// 곱셈 후 할당
		int e = 2;
		e *= a; // e에 e와 a를 곱한 값(10)을 할당
		
		// 나눗셈 후 할당
		int f = 20;
		f /= a; // f를 a로 나눈 값(4)을 할당
		
		// 나머지 후 할당
		int g = 13;
		g %= a; // g를 a로 나눈 나머지(3)를 할당
	}

}

package sec02.ex01;

public class Exchange {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
//		int temp = a;
//		a = b;
//		b = temp;
		
		// int 타입의 exchange하는 공식
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

}

package sec02.ex03;

public class LongEx {

	public static void main(String[] args) {
		byte b = 10;
		int i = 20;
		long l = 30L;
		
		// byte와 int를 더할 때 int 타입으로 변환
		int sum1 = b + i;
		
		// byte와 int와 long을 더할 때 long 타입으로 변환
		long sum2 = i + l + b;
		
		System.out.println(sum1);
		System.out.println(sum2);
		
		// long을 int 타입으로 변환해서 연산하고 싶다면 다운캐스팅을 해줘야 한다.
		int sum3 = (int)l + i + b;
		System.out.println(sum3);
	}

}

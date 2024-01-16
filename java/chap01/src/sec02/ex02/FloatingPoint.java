package sec02.ex02;

public class FloatingPoint {

	public static void main(String[] args) {
		// float 타입은 f로 값을 끝내야 합니다.
		float myNum1 = 5.75f;
		System.out.println(myNum1);
		
		// double 타입은 자바에서 실수형의 기본타입으로 되어있기 때문에
		// d를 입력해도 되고 생략해도 됩니다.
		// 생략하면 double 타입으로 인식합니다.
		double myNum3 = 19.99d;
		double myNum4 = 20.99;
		System.out.println(myNum3);
		System.out.println(myNum4);
		
		// 정밀도 테스트
		float myNum5 = 0.123456789123456789f;
		double myNum6 = 0.123456789123456789;
		System.out.println(myNum5);
		System.out.println(myNum6);
		
		// 10의 거듭제곱을 나타내는 'e'사용하기
		float f1 = 35e3f;
		double d1 = 12e4;
		double d2 = 12e-4;
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(d2);
		
	}

}

package sec14.ex01;

public class LamdaEx {

	public static void main(String[] args) {
		// 람다 표현식을 이용하여 제곱 연산을 구현한 함수를 변수에 할당
		MyFunction square = (int x) -> x * x;
		
		// 변수를 사용하여 람다 표현식 실행
		System.out.println("3의 제곱: " + square.apply(3));
		System.out.println("5의 제곱: " + square.apply(5));
	}

}

interface MyFunction {
	int apply(int x);
}
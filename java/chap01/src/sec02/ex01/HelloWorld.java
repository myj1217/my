package sec02.ex01;

public class HelloWorld {

	public static void main(String[] args) {
//		System 패키지 안의 out 패키지의 println 메서드를 사용
		System.out.println("Hello world!");  // 출력할건데 줄 바꿔서 출력해라
		
//		int는 숫자형 타입을 가진 num이라는 변수 이름에 10이라는 값을 할당
		int num = 10;
		System.out.println(num);
		
		int number, x, y;
		
		number = 20;
		x = 30;
		y = 40;
		
		System.out.println(number);
		System.out.println(x);
		System.out.println(y);
		
//		String 문자형 타입을 가진 name이라는 변수 이름에 java라는 값을 할당
		String name = "java";
		System.out.println(name);
	}

}

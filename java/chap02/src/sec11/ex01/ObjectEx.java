package sec11.ex01;

public class ObjectEx {

	public static void main(String[] args) {
		Object obj1 = new String("Hello"); // String 객체를 Object 변수에 할당
		// Object obj2 = new Integer(10); // Integer 객체를 Object 변수에 할당
		// 생성자 Integer(int)는 버전 9 이후로 deprecated
		int num = 42;
		Object obj2 = Integer.valueOf(num); // Integer 객체의 valueOf 메서드를 Object 변수에 할당
		
		// Object 객체의 getClass 메서드로 클래스 정보 얻기
		// <?> : generic whildcard
		Class<?> class1 = obj1.getClass();
		Class<?> class2 = obj2.getClass();
		
		// Object 객체의 toString() 메서드로 문자열 표현하기
		String str1 = obj1.toString();
		String str2 = obj2.toString();
		
		System.out.println("obj1의 클래스: " + class1);
		System.out.println("obj2의 클래스: " + class2);
		System.out.println("obj1의 문자열 표현: " + str1);
		System.out.println("obj2의 문자열 표현: " + str2);
	}

}

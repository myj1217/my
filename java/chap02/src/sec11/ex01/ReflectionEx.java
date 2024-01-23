package sec11.ex01;

public class ReflectionEx {

	public static void main(String[] args) {
		try {
			// getClass() 메서드를 사용한 예제
			String str = "Hello, Reflection!";
			Class strClass = str.getClass();		
			System.out.println("클래스 이름: " + strClass.getName());
			
			// forName() 메서드를 사용한 예제
			Class intClass = Class.forName("java.lang.Integer"); // class 이름을 대입하는 기능
			System.out.println("클래스 이름: " + intClass.getName());
			
			// sec11.ex01 패키지에서 클래스 가져오기
			Class member = Member.class;
			System.out.println(member.getName());
			System.out.println(member.getSimpleName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

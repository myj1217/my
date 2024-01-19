package sec09.ex01;

public class StaticOuter {
	private static String outerVariable = "Outer";
	
	private static void outerMethod() {
		System.out.println("Outer Method");
	}
	
	static class InnerClass {
		private String innerVariable = "Inner";
		
		private void innerMethod() {
			System.out.println("Inner Method");
		}
		
		public void accessOuter() {
			// 외부 클래스의 static 멤버 변수에 접근
			System.out.println(outerVariable);
			// 외부 클래스의 static 멤버 메서드 호출
			outerMethod();
			innerMethod();
			System.out.println(innerVariable);
		}
	}
	
	public static void run() {
		// 외부 클래스 내부에서 static 내부 클래스 인스턴스 생성
		InnerClass inner = new InnerClass();
		// 내부 클래스의 메서드를 통해 외부 클래스에 접근
		inner.accessOuter();
	}
}

package sec09.ex01;

public class OuterClass3 {
	private static int outerStaticField;
	private int outerField;
	
	public static void outerStaticMethod() {
		System.out.println("Outer static method");
	}
	
	public void outerMethod() {
		System.out.println("Outer method");
	}
	
	public static class StaticInnerClass {
		private static int innerStaticField;
		private int innerField;
		
		public static void innerStaticMethod() {
			System.out.println("Inner static method");
			outerStaticField = 10;
			outerStaticMethod();
		}
		
		public void innerMethod() {
			System.out.println("Inner method");
			// innerField = 20; // 외부 클래스의 인스턴스 필드에는 접근 불가능
			// outerField = 30; // 외부 클래스의 인스턴스 메소드에는 접근 불가능
			// outerMethod(); // 외부 클래스의 인스턴스 메소드 호출 불가능
		}
	}
}

package sec09.ex01;

public class OuterClass {
	private String outerVariable = "Outer";
	
	private void outerMethod() {
		System.out.println("Outer Method");
	}
	
	private class InnerClass {
		private String innerVariable = "Inner";
		
		private void innerMethod() {
			System.out.println("Inner Method");
		}
		
		public void accessOuter() {
			// 외부 클래스의 멤버 변수에 접근
			System.out.println(outerVariable);
			// 외부 클래스의 멤버 메서드 호출
			outerMethod();
		}
	}
	
	public void run() {
		// 외부 클래스 내부에서 내부 클래스 인스턴스 생성
		InnerClass inner = new InnerClass();
		// 내부 클래스의 메서드를 통해 외부 클래스에 접근
		inner.accessOuter();
		// 내부 클래스의 메서드를 통해 메서드에 접근
		inner.innerMethod();
		// 내부 클래스의 메서드를 통해 내부 필드에 접근
		System.out.println(inner.innerVariable);
	}
}

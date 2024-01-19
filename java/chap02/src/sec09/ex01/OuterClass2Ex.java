package sec09.ex01;

// 내부 클래스에서 외부 클래스에 접근 가능
class OuterClass2 {
	private int outerField;
	
	public void outerMethod() {
		System.out.println("Outer method");
	}
	
	class InnerClass {
		public void innerMethod() {
			outerField = 10;
			outerMethod();
			System.out.println("Inner method");
		}
	}
}

public class OuterClass2Ex {

	public static void main(String[] args) {
		OuterClass2 outer2 = new OuterClass2();
		OuterClass2.InnerClass inner = outer2.new InnerClass();
		inner.innerMethod();
	}

}

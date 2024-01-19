package sec09.ex01;

public class OuterClass4 {
	private int outerField = 10;
	
	public void outerMethod() {
		InnerClass innerObj = new InnerClass();
		innerObj.innerMethod();
	}
	
	public class InnerClass {
		private int innerField = 20;
		
		public void innerMethod() {
			System.out.println("Inner field: " + innerField);
			// System.out.println("Outer field: " + outerField);
			System.out.println("Outer field: " + OuterClass4.this.outerField);
		}
	}
	
	public static void main(String[] args) {
		OuterClass4 outerObj = new OuterClass4();
		outerObj.outerMethod();
	}

}

package sec06.ex03;

public class MyClass {
	public void methodA() {
		System.out.println("메서드 A를 호출했습니다.");
	}
	
	public void methodB() {
		System.out.println("메서드 B를 호출했습니다.");
		
		// 메서드 A 호출
		methodA();
	}
	
	public static void main(String[] args) {
		MyClass myObject = new MyClass();
		
		// 메서드 B 호출
		myObject.methodB();
	}

}

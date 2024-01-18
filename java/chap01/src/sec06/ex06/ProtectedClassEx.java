package sec06.ex06;

public class ProtectedClassEx extends ProtectedClass{
	public void someMethod() {
		protectedField = 10;
		protectedMethod();
		System.out.println(protectedField);
	}
	public static void main(String[] args) {
		ProtectedClassEx pro = new ProtectedClassEx();
		pro.someMethod();
	}

}

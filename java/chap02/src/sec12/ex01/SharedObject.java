package sec12.ex01;

public class SharedObject {
	private int value = 0;
	
	// synchronized: 하나의 스레드만 접근할 수 있다.
	public synchronized void increment() {
		value++;
	}
	
	public int getValue() {
		return value;
	}
}

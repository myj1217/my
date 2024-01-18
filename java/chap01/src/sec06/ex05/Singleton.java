package sec06.ex05;

public class Singleton {
	// static = 코드 영역
	private static Singleton instance;
	
	private Singleton() {
		// private 생성자 : 외부에서 직접적으로 개입 불가
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}

package sec12.ex01;

public class ThreadNameEx extends Thread {
	public ThreadNameEx(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("현재 실행하고 있는 스레드 이름: " + getName());
	}
	
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("현재 스레드: " + mainThread.getName());
		
		ThreadNameEx thread1 = new ThreadNameEx("Thread-1");
		ThreadNameEx thread2 = new ThreadNameEx("Thread-2");
		
		thread1.start();
		thread2.start();
		
		// 스레드 이름 변경
		thread1.setName("New-Thread-1");
		thread2.setName("New-Thread-2");
		
		// 변경된 스레드 이름 확인
		System.out.println("thread1에서 변경된 스레드 이름: " + thread1.getName());
		System.out.println("thread2에서 변경된 스레드 이름: " + thread2.getName());
	}

}

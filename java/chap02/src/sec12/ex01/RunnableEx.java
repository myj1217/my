package sec12.ex01;

class MyRunnable implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("MyRunnable: " + i);
			try {
				Thread.sleep(1000); // 1초에 한번씩 출력
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RunnableEx {

	public static void main(String[] args) {
		System.out.println("Main Thread 시작");
		
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start(); // 새로운 스레드 시작
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("Main Thread: " + i);
			try {
				Thread.sleep(500); // 0.5초에 한번씩 출력
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main Thread 종료");
	}

}

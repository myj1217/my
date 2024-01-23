package sec12.ex01;

public class AnonymousRunEx {

	public static void main(String[] args) {
		// Runnable 익명 구현 객체
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					System.out.println("Thread " + Thread.currentThread().getId() + ": Count " + i);
					try {
						Thread.sleep(1000); // 1초 대기
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		// 스레드 생성 및 실행
		Thread thread1 = new Thread(myRunnable);
		thread1.start();
		
		Thread thread2 = new Thread(myRunnable);
		thread2.start();
	}

}

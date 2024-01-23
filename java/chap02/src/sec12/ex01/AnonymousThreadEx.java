package sec12.ex01;

public class AnonymousThreadEx {

	public static void main(String[] args) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("스레드 실행 중: " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		thread.start(); // 스레드 실행 시작
		
		// 메인 스레드는 자식 스레드가 실행될 동안 다른 작업을 수행할 수 있음
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 스레드 실행 중: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

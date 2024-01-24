package sec12.ex02;

public class DaemonEx {

	public static void main(String[] args) {
		Thread daemonThread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000); // 1초마다 로그 출력
					System.out.println("데몬 스레드 실행중...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		daemonThread.setDaemon(true); // 데몬 스레드로 설정
		daemonThread.start(); // 데몬 스레드 실행
		
		// 메인 스레드에서 작업을 수행하는 동안 데몬 스레드는 백그라운드에서 계속 실행됨
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 스레드 실행중...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 메인 스레드 종료 시 데몬 스레드도 함께 종료됨
		System.out.println("메인 스레드 종료중...");
	}

}

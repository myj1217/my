package sec12.ex01;

public class CurrentThreadEx {

	public static void main(String[] args) {
		// 현재 실행중인 스레드 객체 얻기
		Thread currentThread = Thread.currentThread();
		
		// 스레드의 이름과 우선순위 출력
		System.out.println("현재 스레드 이름: " + currentThread.getName());
		// 우선순위 범위는 1부터 10까지
		// 우선순위를 커스텀할 수는 있으나 인위적으로 조절하게되면 cpu 과부하가 발생할 수 있음
		System.out.println("현재 우선순위 스레드: " + currentThread.getPriority()); 
		
		// 스레드 그룹 출력
		ThreadGroup threadGroup = currentThread.getThreadGroup();
		if (threadGroup != null) {
			System.out.println("스레드 그룹: " + threadGroup.getName());
		}
		
		// 스레드의 상태 출력
		System.out.println("스레드 상태: " + currentThread.getState());
		
		// 스레드 ID 출력
		System.out.println("스레드 ID: " + currentThread.getId());
		
		// 스레드 클래스 정보 출력
		System.out.println("스레드 클래스: " + currentThread.getClass().getName());
	}

}

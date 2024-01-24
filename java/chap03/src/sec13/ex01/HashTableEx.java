package sec13.ex01;

import java.util.Hashtable;

public class HashTableEx {

	public static void main(String[] args) {
		// Hashtable 생성 (키: 문자열, 값: 정수)
		Hashtable<String, Integer> hashtable = new Hashtable<>();
		
		// 데이터를 추가하는 스레드 생성
		Thread addThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				hashtable.put("key" + i, i);
				System.out.println("추가: key" + i + " -> " + i); // 추가: key1 -> 1
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 데이터를 조회하는 스레드 생성
		Thread getThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				int value = hashtable.get("key" + i);
				System.out.println("조회: key" + i + " -> " + value);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 스레드 시작
		addThread.start();
		getThread.start();
		
		// 메인 스레드가 두 스레드의 작업을 기다림
		try {
			addThread.join();
			getThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}

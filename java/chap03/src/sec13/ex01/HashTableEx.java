package sec13.ex01;

import java.util.Hashtable;

public class HashTableEx {

   public static void main(String[] args) {
        // Hashtable 생성 (키: 문자열, 값: 정수)
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // 객체를 사용하여 동기화
        Object lock = new Object();

        // 데이터 추가하는 스레드 생성
        Thread addThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                synchronized (lock) {
                    // 데이터가 이미 존재하면 대기
                    // 다중 스레드 환경에서 여러스레드가 먼저 put을 호출하면 일관성이 깨질수 있음.
                   // 데이터가 이미 존재하는지 확인한 후에 데이터를 추가하는것이 좋음.
                    while (hashtable.containsKey("key" + i)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 데이터 추가
                    hashtable.put("key" + i, i);
                    System.out.println("추가: key" + i + " -> " + i);

                    // 대기 중인 다른 스레드를 깨움
                    lock.notifyAll();
                }
            }
        });

        // 데이터 조회하는 스레드 생성
        Thread getThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                synchronized (lock) {
                    while (!hashtable.containsKey("key" + i)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 데이터 조회 및 출력
                    int value = hashtable.get("key" + i);
                    System.out.println("조회: key" + i + " -> " + value);

                    // 대기 중인 다른 스레드를 깨움
                    lock.notifyAll();
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
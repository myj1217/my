package sec12.ex01;

public class SharedObjectEx {
	   public static void main(String[] args) {
	      SharedObject sharedObject = new SharedObject();

	        // 첫 번째 스레드 정의
	        Thread thread1 = new Thread(() -> {
	            for (int i = 0; i < 5; i++) {
	                    sharedObject.increment();
	                    System.out.println("Thread 1: " + sharedObject.getValue());
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        // 두 번째 스레드 정의
	        Thread thread2 = new Thread(() -> {
	            for (int i = 0; i < 5; i++) {
	                    sharedObject.increment();
	                    System.out.println("Thread 2: " + sharedObject.getValue());
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        // 두 개의 스레드 실행
	        thread1.start();
	        thread2.start();
	        
	        // 스레드가 모두 종료될 때까지 기다림
	        // join(): 다른 스레드의 작업이 완료될 때까지 현재 스레드를 일시적으로 정지시킨다.
	        // 스레드 간의 작업의 순서를 제어하거나 특정 스레드가 종료될 때까지 기다린 상황에서 사용된다.
	        try {
	        	thread1.join();
	        	thread2.join();
	        } catch (InterruptedException e) {
	        	e.printStackTrace();
	        }
	        
	        // 최종 결과 출력
	        System.out.println("Final Value: " + sharedObject.getValue());
	   }

	}
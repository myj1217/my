package sec10.ex01;

public class ArrayIndexEx {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3}; // int numbers[] = {1, 2, 3}; 와 같음
		try {
			// 유효한 인덱스 범위 내의 값을 출력
			System.out.println(numbers[0]);
			System.out.println(numbers[2]);
			
			// 유효하지 않은 인덱스에 접근
			System.out.println(numbers[3]);
			System.out.println(numbers[-1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 범위를 벗어난 접근이 발생하였습니다.");
			System.out.println("에러 메시지: " + e.getMessage());
		}
	}

}

package sec04.ex03;

public class ContinueEx {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue; // i가 짝수일 때 다음 반복으로 건너뜀
			}
			System.out.println(i);
		}
	}

}

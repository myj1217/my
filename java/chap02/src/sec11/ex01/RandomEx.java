package sec11.ex01;

import java.util.Arrays;

public class RandomEx {

	public static void main(String[] args) {
		int[] lottoNumbers = lotto();
		System.out.println("로또 번호: " + Arrays.toString(lottoNumbers));
	}
	
	public static int[] lotto() {
		int[] numbers = new int[6];
		
		for (int i = 0; i < 6; i++) {
			numbers[i] = (int) (Math.random() * 45) + 1;
		}
		
		return numbers;
	}

}

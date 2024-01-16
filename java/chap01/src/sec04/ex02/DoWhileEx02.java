package sec04.ex02;

import java.util.Scanner;

public class DoWhileEx02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number;
		
		do {
			System.out.print("1부터 10 사이의 숫자를 입력하세요: ");
			number = scanner.nextInt();
		} while (number < 1 || number > 10);
		
		System.out.println("입력한 숫자는 " + number + "입니다.");
	}

}

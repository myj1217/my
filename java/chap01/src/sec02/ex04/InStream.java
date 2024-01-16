package sec02.ex04;

import java.util.Scanner;

public class InStream {

	public static void main(String[] args) {
		// System.in 은 Scanner를 생성자로 전달되어 사용자가 입력을 읽어들일 수 있게 됩니다.
		// System.in.read()는 한 단어만 읽어들일 수 있어서 안씀
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string: ");
		
		// nextLine(): enter키가 입력되기 전까지 대기 상태가 되며 enter키가 입력되면 입력된 내용을 문자열로 읽습니다.
		String inputString = scan.nextLine();
		// 키보드로 입력된 내용을 출력합니다.
		System.out.println("You entered: " + inputString);

	}

}

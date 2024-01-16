package sec02.ex04;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String Data;
		
		while(true) {
			Data = scan.nextLine();
			
			// equals(): 문자열(String)이 일치한지 비교하는 메서드
			// Data에 들어있는 값과 q를 비교합니다. 일치하면 true
			if(Data.equals("q")) {
				break;
			}
		}
		System.out.println("종료되었습니다.");
	}

}

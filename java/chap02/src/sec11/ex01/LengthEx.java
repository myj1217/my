package sec11.ex01;

import java.util.Scanner;

public class LengthEx {

	public static void main(String[] args) {
		// Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 입력 받기
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
     
        if (name.length() <= 5) {
            // 입력 받은 내용 출력하기
            System.out.println("이름: " + name);
   } else {
       System.out.println("입력값이 너무 깁니다. 5자 이내로 입력해주세요.");
   }

	}

}

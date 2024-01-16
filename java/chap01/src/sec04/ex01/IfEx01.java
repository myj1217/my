package sec04.ex01;

public class IfEx01 {

	public static void main(String[] args) {
		int x = 10;
		
		if (x > 0) {
			System.out.println("x는 양수입니다.");
		} else if (x < 0) {
			System.out.println("x는 음수입니다.");
		} else {
			System.out.println("x는 0입니다.");
		}
	}

}

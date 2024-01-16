package sec04.ex01;

public class IfEx02 {

	public static void main(String[] args) {
		// 1부터 6까지의 무작위 주사위 값 생성
		// Math.random() : 0이상 1미만의 난수 생성
		int diceValue = (int) (Math.random() * 6) + 1;
		
		System.out.println("주사위의 값: " + diceValue);
		
		if (diceValue == 1) {
			System.out.println("1이 나왔습니다.");
		} else if (diceValue == 2) {
			System.out.println("2이 나왔습니다.");
		} else if (diceValue == 3) {
			System.out.println("3이 나왔습니다.");
		} else if (diceValue == 4) {
			System.out.println("4이 나왔습니다.");
		} else if (diceValue == 5) {
			System.out.println("5이 나왔습니다.");
		} else {
			System.out.println("6이 나왔습니다.");
		}
	}

}

package sec10.ex03;

public class ThrowsEx2 {

	public static void main(String[] args) {
		try {
			int result = divideNumbers("가", "2");
			System.out.println("Result: " + result);
		} catch (NumberFormatException e) {
			System.out.println("잘못된 번호 형식입니다: " + e.getMessage());
		}
	}
	
	public static int divideNumbers(String num1, String num2) throws NumberFormatException {
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		return number1 / number2;
	}

}

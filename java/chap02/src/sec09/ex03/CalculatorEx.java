package sec09.ex03;

public class CalculatorEx {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		// Calculator 인터페이스를 익명 구현 객체로 생성하여 로컬 변수로 사용
		Calculator addition = new Calculator() {
			@Override
			public int calculate(int a, int b) {
				return a + b;
			}
		};
		
		MathUtils.performCalculation(a, b, addition);
		
		// 다른 연산을 위해 새로운 익명 구현 객체 생성
		Calculator subtraction = new Calculator() {
			@Override
			public int calculate(int a, int b) {
				return a - b;
			}
		};
		
		MathUtils.performCalculation(a, b, subtraction);
	}

}

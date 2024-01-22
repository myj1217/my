package sec09.ex03;

public class MathUtils {
	// static은 인스턴스 생성 없이 바로 사용 가능함
	public static void performCalculation(int x, int y, Calculator calculator) {
		int result = calculator.calculate(x, y);
		System.out.println("Result: " + result);
	}
}

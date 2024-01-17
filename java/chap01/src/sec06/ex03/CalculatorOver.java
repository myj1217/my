package sec06.ex03;

public class CalculatorOver {
	public int add(int a, int b) {
		return a + b;
	}
	
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public double add(double a, double b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		CalculatorOver calculOver = new CalculatorOver();
		
		int sum1 = calculOver.add(3, 5);
		System.out.println("합계 1: " + sum1);
		
		int sum2 = calculOver.add(3, 5, 7);
		System.out.println("합계 2: " + sum2);
		
		double sum3 = calculOver.add(2.5, 3.7);
		System.out.println("합계 3: " + sum3);
	}

}

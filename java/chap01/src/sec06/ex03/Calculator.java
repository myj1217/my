package sec06.ex03;

public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}
	
	public void printInfo(String name, int age) {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		int sum = calculator.add(3, 5);
		System.out.println("합계: " + sum);
		
		calculator.printInfo("자바", 30);
	}

}

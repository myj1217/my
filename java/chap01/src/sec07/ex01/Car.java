package sec07.ex01;

class Vehicle {
	protected String brand = "Volvo"; // 같은 패키지 내에 접근가능하고 상속관계에 있는지 여부
	public void honk() {
		System.out.println("Tuut, tuut!");
	}
}
	
class Car extends Vehicle {
	private String modelName = "Mustang";
	public static void main(String[] args) {
		// myCar 객체 만들기
		Car myCar = new Car();
			
		// myCar 객체의 경적() 메서드를 호출합니다.
		myCar.honk();
			
		System.out.println(myCar.brand + " " + myCar.modelName);
	}
}
	



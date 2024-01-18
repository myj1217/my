package sec07.ex01;

public class BigCarEx {

	public static void main(String[] args) {
		BigCar bigcar1 = new BigCar("hyundai");
		BigCar bigcar2 = new BigCar("Volvo", "Model 8");
		BigCar bigcar3 = new BigCar("hyundai", "X10", 2024);
		
		System.out.println(bigcar1);
		System.out.println(bigcar2);
		System.out.println(bigcar3);
	}

}

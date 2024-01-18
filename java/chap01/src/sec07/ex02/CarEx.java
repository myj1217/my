package sec07.ex02;

public class CarEx {

	public static void main(String[] args) {
		// Car car1 = new ElectricCar();
		ElectricCar car1 = new ElectricCar();
		// Car car2 = new GasolineCar();
		GasolineCar car2 = new GasolineCar();
		
		car1.drive();
		car2.drive();
		car1.charge();
		car2.refuel();
	}

}

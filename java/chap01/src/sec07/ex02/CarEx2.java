package sec07.ex02;

public class CarEx2 {

	public static void main(String[] args) {
		Car car1 = new ElectricCar();
		Car car2 = new GasolineCar();
		
		car1.drive();
		car2.drive();
		
		// instanceof : 객체의 타입을 확인하는 녀석
		if (car1 instanceof ElectricCar) {
			ElectricCar electricCar = (ElectricCar) car1; // 마치 다운캐스팅
			electricCar.charge();
		}
		
		if (car2 instanceof GasolineCar) {
			GasolineCar gasolineCar = (GasolineCar) car2;
			gasolineCar.refuel();
		}
	}

}

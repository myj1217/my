package sec07.ex02;

class Car {
	public void drive() {
		System.out.println("Driving a car");
	}
}

class ElectricCar extends Car {
	@Override
	public void drive() {
		System.out.println("Driving an electric car");
	}
	
	public void charge() {
		System.out.println("Charging the electric car");
	}
}

class GasolineCar extends Car {
	@Override
	public void drive() {
		System.out.println("Driving a gasoline car");
	}
	public void refuel() {
		System.out.println("Refueling the gasoline car");
	}
}
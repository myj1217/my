package sec07.ex01;

public class BigCar {
	private String brand;
	private String model;
	private int year;
	
	// 생성자 오버로딩
	public BigCar(String brand) {
		this.brand = brand;
	}
	
	public BigCar(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public BigCar(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "BigCar [brand=" + brand + ", model=" + model + ", year=" + year + "]";
	}
	
	
}

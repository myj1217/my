package sec06.ex04;

public class ThisEx {
	private int number;
	
	public ThisEx(int number) {
		this.number = number;
	}
	
	public void setNumber (int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void printNumber() {
		System.out.println("Number: " + this.getNumber());
	}
	
	public static void main(String[] args) {
		ThisEx thisEx = new ThisEx(42);
		thisEx.printNumber();
	}

}

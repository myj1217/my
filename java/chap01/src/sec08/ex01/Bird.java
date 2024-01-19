package sec08.ex01;

public class Bird implements Animal{
	@Override
	public void makeSound() {
		System.out.println("째잭!");
	}
	
	@Override
	public void move() {
		System.out.println("하늘을 납니다.");
	}
	
	public void move1() {
		System.out.println("하늘을 납니다.");
	}
}

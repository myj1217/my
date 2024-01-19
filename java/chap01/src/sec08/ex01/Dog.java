package sec08.ex01;

public class Dog implements Animal{
	@Override
	public void makeSound() {
		System.out.println("으르렁!");
	}
	
	@Override
	public void move() {
		System.out.println("네 발로 달립니다.");
	}
}

package sec08.ex01;

public class AnimalEx {

	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal bird = new Bird();
		
		dog.makeSound();
		dog.move();
		
		bird.makeSound();
		bird.move();
	}

}

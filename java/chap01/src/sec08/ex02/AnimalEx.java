package sec08.ex02;

public class AnimalEx {

	public static void main(String[] args) {
		AnimalSound animalSound = new AnimalSound();
		
		Animal dog = new Dog();
		Animal cat = new Cat();
		
		// Animal animal = dog;
		animalSound.makeSound(dog);
		animalSound.makeSound(cat);

	}

}

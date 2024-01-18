package sec07.ex01;

class Animal {
	protected String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(name + "is eating.");
	}
}

class Dog extends Animal {
	private String breed;
	
	public Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	
	public void bark() {
		System.out.println(name + " is barking.");
	}
	
	public void displayBreed() {
		System.out.println(name + " is a " + breed + ".");
	}
}

public class DogEx {

	public static void main(String[] args) {
		Dog dog = new Dog("맥스", "래브라도 리트리버");
		dog.displayBreed();
		dog.eat();
		dog.bark();
	}

}

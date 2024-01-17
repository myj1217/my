package sec06.ex04;

public class DogEx {

	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog("dodo");
		Dog dog3 = new Dog("dudu", 3);
		
		System.out.println("dog1 - Name: " + dog1.getName() + ", Age: " + dog1.getAge());
		System.out.println("dog2 - Name: " + dog2.getName() + ", Age: " + dog2.getAge());
		System.out.println("dog3 - Name: " + dog3.getName() + ", Age: " + dog3.getAge());
	}

}

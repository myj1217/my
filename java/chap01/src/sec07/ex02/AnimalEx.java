package sec07.ex02;

public class AnimalEx {

	public static void main(String[] args) {
		// 자식 클래스 객체를 부모 클래스 타입으로 자동 타입 변환
		Animal animal1 = new Dog();
		Animal animal2 = new Cat();
		
		animal1.makeSound();
		animal2.makeSound();

	}

}

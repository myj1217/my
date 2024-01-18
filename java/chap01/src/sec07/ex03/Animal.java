package sec07.ex03;

public abstract class Animal {
	// 필드
	// protected : 같은 패키지 내에, 혹은 자식이 접근 가능
	protected String name;
	
	// 생성자
	public Animal(String name) {
		this.name = name;
	}
	
	// 추상 메서드
	public abstract void makeSound();
}

class Dog extends Animal {
	public Dog(String name) {
		// Animal(부모)의 생성자 호출
		super(name);
	}
	
	// 아무리 abstract로 꼭 써줘야 한다고 해서 Override를 빼먹어서는 안된다.
	// Override는 관례이므로 꼭 붙여주도록 하자.
	@Override
	public void makeSound() {
		System.out.println(name + " is barking.");
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println(name + " is meowing.");
	}
}
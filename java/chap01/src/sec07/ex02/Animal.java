package sec07.ex02;

class Animal {
	public void makeSound() {
		System.out.println("동물은 소리를 냅니다.");
	}
}

class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Dog barks");
	}
}

class Cat extends Animal {
	@Override
	public void makeSound() {
		System.out.println("Cat meows");
	}
}
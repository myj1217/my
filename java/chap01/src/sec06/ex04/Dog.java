package sec06.ex04;

public class Dog {
	private String name;
	private int age;
	
	// 기본 생성자
	public Dog() {
		this.name = "Unknown";
		this.age = 0;
	}
	
	// 이름만 받는 생성자
	public Dog(String name) {
		this.name = name;
		this.age = 0;
	}
	
	// 이름과 나이를 받는 생성자
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public int getAge() {
		return this.age;
	}

//	public void setAge(int age) {
//		this.age = age;
//	}
	
	
}

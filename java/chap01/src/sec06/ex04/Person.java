package sec06.ex04;

public class Person {
	// 필드
	private String name;
	private int age;
	
	// 매개변수
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 매개변수가 없는 생성자
	public Person() {
		// 기본값으로 초기화
		this.name = "Unknown";
		this.age = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public static void main(String[] args) {
		// 매개변수를 받는 생성자를 사용하여 객체 생성
		Person person1 = new Person("자바", 30);
		System.out.println(person1.getName());
		System.out.println(person1.getAge());
		
		Person person2 = new Person();
		System.out.println(person2.getName());
		System.out.println(person2.getAge());
	}

}

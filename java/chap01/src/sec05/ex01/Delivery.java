package sec05.ex01;

class Person {
	private String name; // 클래스 내에서만 사용하겠다.
	
	public Person(String name) {
		this.name = name; // 직접적인 접근은 불허한다.
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

public class Delivery {
	public static void main(String[] args) {
		Person person = new Person("민석");
		System.out.println("메서드 호출 전: " + person.getName());
		
		changeName(person);
		System.out.println("메서드 호출 후: " + person.getName());
	}
	public static void changeName(Person p) {
		p.setName("민준");
	}
}

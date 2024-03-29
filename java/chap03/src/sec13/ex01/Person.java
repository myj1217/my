package sec13.ex01;

import java.util.Objects;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// hashCode() 메서드 오버라이딩
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	// equals() 메서드 오버라이딩
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	// Getter 메서드
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
}

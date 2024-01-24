package sec13.ex01;

import java.util.Objects;

public class Students {
	private String name;
	private int age;
	
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		// 객체가 자기 자신과 동일한지를 비교한다.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
}

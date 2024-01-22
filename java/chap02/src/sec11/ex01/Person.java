package sec11.ex01;

import java.util.Objects;

public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	// name 필드의 getter 메서드
	public String getName() {
		return name;
	}
	
	// name 필드의 setter 메서드
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 매개값이 Person 타입인지 확인합니다.
		if (obj instanceof Person) {
			// Person 타입으로 반환하고
			Person person = (Person) obj;
			// name 필드값이 동일한지 검사 후
			if (name.equals(person.name)) {
				// 동일하면 true를 반환합니다.
				return true;
			}
		}
		// 매개값이 Person 타입이 아니거나
		// name 필드값이 다른 경우 false를 반환합니다.
		return false;
	}
	@Override
	// Override를 쓴다는 것은 hashCode가 부모 것이라는 것을 알 수 있다.
	public int hashCode() {
		return Objects.hash(name); // name 필드의 hash 코드값을 반환합니다.
	}
}

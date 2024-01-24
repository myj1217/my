package sec13.ex01;

import java.util.HashSet;

public class HashSetEx2 {

	public static void main(String[] args) {
		// HashSet 생성
		HashSet<Person> personSet = new HashSet<>();
		
		// 데이터 추가
		Person person1 = new Person("소연", 25);
		Person person2 = new Person("재현", 30);
		Person person3 = new Person("소연", 25); // 인스턴스는 다르나 문자열이 같음 (중복요소)
		
		personSet.add(person1);
		personSet.add(person2);
		personSet.add(person3);
		
		// 데이터 조회
		for (Person person: personSet) {
			System.out.println("이름: " + person.getName() + ", 나이: " + person.getAge());
		}
	}

}

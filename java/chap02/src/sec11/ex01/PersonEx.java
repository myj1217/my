package sec11.ex01;

public class PersonEx {

	public static void main(String[] args) {
		// Person 객체 생성
		Person person1 = new Person("Alice");
		Person person2 = new Person("Alice");
		Person person3 = new Person("Jain");
		
		// equals 메서드를 사용하여 동일성 비교
		boolean areEqual1 = person1.equals(person2);
		boolean areEqual2 = person1.equals(person3);
		System.out.println("person1과 person2는 같은 사람입니까? " + areEqual1);
		System.out.println("person1과 person3는 같은 사람입니까? " + areEqual2);
		
		// hashCode 비교
		int hashCode1 = person1.hashCode();
		int hashCode2 = person2.hashCode();
		int hashCode3 = person3.hashCode();
		boolean CodesEqual1 = hashCode1 == hashCode2;
		boolean CodesEqual2 = hashCode1 == hashCode3;
		System.out.println("person1과 person2의 해시 코드가 같습니까? " + CodesEqual1);
		System.out.println("person1과 person3의 해시 코드도 같습니까? " + CodesEqual2);
		
	}

}

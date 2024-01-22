package sec10.ex01;

public class ClassCastEx {

	public static void main(String[] args) {
		Animal animal = new Dog();
		
		// 부모 클래스 타입에서 자식 클래스 타입으로 형변환을 시도
		// Cat cat = (Cat) animal; // 잘못된 형변환이므로 ClassCastException 발생
		
		try {
			if (animal instanceof Dog) {
				Dog dog = (Dog) animal;
				System.out.println("형변환 성공: Dog 객체 생성");
				dog.bark();
			} else {
				throw new ClassCastException("형변환 실패: Dog 타입으로 변환할 수 없음");
			}
		} catch (ClassCastException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
	}

}

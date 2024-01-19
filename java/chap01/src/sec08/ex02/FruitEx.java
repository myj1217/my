package sec08.ex02;

public class FruitEx {

	public static void main(String[] args) {
		Fruit fruit1 = new Apple();
		Fruit fruit2 = new Banana();
		
		fruit1.eat();
		fruit2.eat();
		
		// fruit1.peel(); // 자동 타입 변환으로 인한 에러
		
		if (fruit1 instanceof Apple) {
			Apple apple = (Apple) fruit1;
			apple.peel();
		}
		
		if (fruit2 instanceof Banana) {
			Banana banana = (Banana) fruit2;
			banana.peel();
		}
	}

}

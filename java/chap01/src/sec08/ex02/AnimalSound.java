package sec08.ex02;

public class AnimalSound {
	// 일일히 다운캐스팅을 해주지 않아도 원샷으로 해결 가능
	// 실무에 가장 가까운 형태
	public void makeSound(Animal animal) {
		animal.sound();
	}
}

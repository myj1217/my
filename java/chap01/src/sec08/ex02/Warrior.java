package sec08.ex02;

public class Warrior extends Character implements Attackable {
	@Override
	void move() {
		System.out.println("전사가 이동합니다.");
	}
	
	@Override
	public void attack() {
		System.out.println("전사가 공격합니다.");
	}
}

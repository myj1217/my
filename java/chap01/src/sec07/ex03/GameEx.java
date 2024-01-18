package sec07.ex03;

public class GameEx {

	public static void main(String[] args) {
		Warrior warrior = new Warrior("Aragorn", 10);
		Mage mage = new Mage("Gandalf", 15);
		
		warrior.attack();
		warrior.move();
		warrior.shieldBash();
		
		mage.attack();
		mage.move();
		mage.teleport();
		System.out.println("======================");
		
		GameCharacter ch = null;
		
		// 변수 자동 타입 변환 및 재정의된 메서드 호출
		ch = new Warrior("Aragorn", 10);
		ch.attack();
		
		ch = new Mage("Gandalf", 15);
		ch.attack();
		System.out.println("======================");
		
		// 메서드의 다형성
		powerful(new Warrior("Aragorn2", 20));
		powerful(new Mage("Gandalf2", 25));
	}
	
	// 코드 구역에 저장되어 공유하며 사용할 수 있다.
	public static void powerful(GameCharacter ch) {
		ch.attack();
	}

}

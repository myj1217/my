package sec08.ex02;

public class GameEx {

	public static void main(String[] args) {
		Warrior warrior = new Warrior();
		Mage mage = new Mage();
		
		warrior.move();
		warrior.attack();
		
		mage.move();
		mage.attack();
	}

}

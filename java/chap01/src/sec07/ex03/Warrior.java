package sec07.ex03;

class Warrior extends GameCharacter {
	public Warrior(String name, int level) {
		super(name, level);
	}
	
	@Override
	public void attack() {
		System.out.println(name + " 검을 사용하여 공격합니다.");
	}
	
	public void shieldBash() {
		System.out.println(name + " 방패로 막고 있습니다.");
	}
}

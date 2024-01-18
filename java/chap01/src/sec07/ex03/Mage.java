package sec07.ex03;

class Mage extends GameCharacter {
	public Mage(String name, int level) {
		super(name, level);
	}
	
	@Override
	public void attack() {
		System.out.println(name + " 불을 던집니다.");
	}
	
	public void teleport() {
		System.out.println(name + " 다른 장소로 순간이동 합니다.");
	}
}

package sec07.ex03;

public abstract class GameCharacter {
	protected String name;
	protected int level;
	
	public GameCharacter(String name, int level) {
		this.name = name;
		this.level = level;
	}
	
	public abstract void attack();
	
	public void move() {
		System.out.println(name + " is moving.");
	}
	
	public void heal() {
		System.out.println(name + " is healing.");
	}
}

package sec06.ex04;

public class Cat {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setCatInfo(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
}

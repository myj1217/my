package sec06.ex04;

public class CatInfoEx {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.setCatInfo("apple", 2);
		Cat cat1 = new Cat();
		cat1.setCatInfo("dabi", 4);
		Cat cat2 = new Cat();
		cat2.setCatInfo("lotto", 1);
		
		System.out.println("Name: " + cat.getName());
		System.out.println("Age: " + cat.getAge());
		System.out.println("Name: " + cat1.getName());
		System.out.println("Age: " + cat1.getAge());
		System.out.println("Name: " + cat2.getName());
		System.out.println("Age: " + cat2.getAge());
	}

}

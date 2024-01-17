package sec06.ex03;

public class StaticPublicEx {
	public static int publicStatic = 10;
	private static int privateStatic = 20;
	public int publicInstance = 30;
	private int privateInstance = 40;
	
	public static void publicStaticM() {
		System.out.println("This is a public static method.");
	}
	
	private static void privateStaticM() {
		System.out.println("This is a private static method.");
	}
	
	public void publicInstanceM() {
		System.out.println("This is a public instance method.");
	}
	
	public void privateInstanceM() {
		System.out.println("This is a private instance method.");
	}
	
	public static void main(String[] args) {
		// 클래스 멤버에 접근하기
		System.out.println(publicStatic);
		System.out.println(privateStatic);
		publicStaticM();
		privateStaticM();
		
		// 인스턴스 생성
		StaticPublicEx instance = new StaticPublicEx();
		// 인스턴스 멤버에 접근하기
		System.out.println(instance.publicInstance);
		System.out.println(instance.privateInstance);
		instance.publicInstanceM();
		instance.privateInstanceM();
	}

}

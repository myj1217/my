package sec10.ex01;

public class NullPointEx {

	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException이 발생했습니다.");
		}
	}

}

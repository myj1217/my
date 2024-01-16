package sec02.ex04;

public class EqualEx {

	public static void main(String[] args) {
		int a = 5;
		int b = 5;
		boolean result = (a == b);
		System.out.println(result);
		
		String str1 = "Hello";
		String str2 = "Hello";
		// 값을 비교해서 true가 아닌 값이 같기 때문에 같은 주소를 가리키고 있어서 true로 나온 것
		boolean result2 = (str1 == str2);
		// 값이 같은지 비교하기 위해서는 반드시 equals 라는 메서드를 사용해야 한다.
		boolean result3 = str1.equals(str2);
		System.out.println(result2);
		System.out.println(result3);
	}

}

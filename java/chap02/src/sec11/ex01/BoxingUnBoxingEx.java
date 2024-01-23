package sec11.ex01;

public class BoxingUnBoxingEx {

	public static void main(String[] args) {
		// 박싱(Boxing)
		Integer number = new Integer(10); // int 값을 감싸는 Integer 객체 생성 (deprecated since )
		Integer num = Integer.valueOf(10); // Wrapper 클래스의 정적 메서드 valueOf()를 사용
		
		// 언박싱(UnBoxing)
		int value = num.intValue(); // Integer 객체를 int 값으로 변환
		
		// 언박싱 후 다양한 기능으로 활용
		String strValue = num.toString();
		int parsedValue = Integer.parseInt("20");
		
		System.out.println(num);
		System.out.println(value);
		System.out.println(strValue);
	}

}

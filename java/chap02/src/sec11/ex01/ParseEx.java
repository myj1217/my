package sec11.ex01;

public class ParseEx {

	public static void main(String[] args) {
		int number = Integer.parseInt("123"); // 문자열을 정수로 변환
	      System.out.println(number);

	      double decimal = Double.parseDouble("3.14"); // 문자열을 부동 소수점 숫자로 변환
	      System.out.println(decimal);

	      boolean flag = Boolean.parseBoolean("true"); // 문자열을 불리언으로 변환
	      System.out.println(flag);

	      long bigNumber = Long.parseLong("9876543210"); // 문자열을 long으로 변환
	      System.out.println(bigNumber);

	      float floatValue = Float.parseFloat("2.718"); // 문자열을 float으로 변환
	      System.out.println(floatValue);

	      short shortValue = Short.parseShort("500"); // 문자열을 short로 변환
	      System.out.println(shortValue);

	      byte byteValue = Byte.parseByte("100"); // 문자열을 byte로 변환
	      System.out.println(byteValue);

	      String strChar = "A";
	      char charValue = strChar.charAt(0); // 문자열에서 첫 번째 문자를 추출하여 char로 변환
	      System.out.println(charValue);
	}

}

package sec11.ex01;

public class EqualsEx {

	public static void main(String[] args) {
	      String str1 = new String("Hello");
	      String str2 = new String("Hello");
	      String str3 = str1;

	      boolean equalsResult = str1.equals(str2);
	      boolean doubleEqualsResult = (str1 == str2);
	      boolean tripleEqualsResult = (str1 == str3);

	      System.out.println("str1.equals(str2): " + equalsResult);           
	      System.out.println("str1 == str2: " + doubleEqualsResult);      
	      System.out.println("str1 == str3: " + tripleEqualsResult); 
	}

}

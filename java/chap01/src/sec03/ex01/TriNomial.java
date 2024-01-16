package sec03.ex01;

public class TriNomial {

	public static void main(String[] args) {
		int x = 5;
		int y = 10;
		
		int max = (x > y) ? x : y;
		System.out.println("최댓값: " + max);
		
		String result = (x % 2 == 0) ? "짝수" : "홀수";
		System.out.println("결과: " + result);
		
		int absoluteValue = (x < 0) ? -x : x;
		System.out.println("절댓값: " + absoluteValue);
	}

}

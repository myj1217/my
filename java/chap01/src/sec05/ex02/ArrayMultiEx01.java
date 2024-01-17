package sec05.ex02;

public class ArrayMultiEx01 {

	public static void main(String[] args) {
		// [][] : '행'과 '열'을 뜻함
		int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7}};
		System.out.println(myNumbers[0][0]);
		myNumbers[0][0] = 9;
		System.out.println(myNumbers[0][0]);
		System.out.println("===============");
		System.out.println(myNumbers[1][2]);
		myNumbers[1][2] = 88;
		System.out.println(myNumbers[1][2]);
	}

}

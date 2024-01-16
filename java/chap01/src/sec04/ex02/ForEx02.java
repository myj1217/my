package sec04.ex02;

public class ForEx02 {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				int result = j * i;
				System.out.println(j + " * " + i + " = " + result + "\t");
			}
			System.out.println();
		}
	}

}

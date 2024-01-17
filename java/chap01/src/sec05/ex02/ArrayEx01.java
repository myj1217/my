package sec05.ex02;

public class ArrayEx01 {

	public static void main(String[] args) {
		int[] scores = {80, 90, 70, 85, 95};
		
		double avg = 0;
		for (int i = 0; i < scores.length; i++) {
			avg += scores[i];
		}
		avg /= scores.length;
		
		System.out.println(avg);
	}

}

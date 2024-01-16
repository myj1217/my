package sec02.ex01;

public class OperationNumber {

	public static void main(String[] args) {
		int hour = 2;
		int minute = 3;
		System.out.println(hour + "시간 " + minute + "분");
		
		int total = (hour*60) + minute;
		System.out.println("총 " + total + "분 입니다.");
	}

}

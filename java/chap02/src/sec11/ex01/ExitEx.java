package sec11.ex01;

public class ExitEx {
	public static void main(String[] args) {
		try {
			int result = divide(10, 0);
			System.out.println("나눈 결과: " + result);
			System.exit(0); // 0: 정상 종료
		} catch (ArithmeticException e) {
			// 예외 처리
			System.out.println("0으로 나눌 수 없습니다.");
			System.err.println("예외가 발생하여 프로그램을 비정상적으로 종료합니다.");
			System.err.println("예외 정보: " + e.toString());
			System.exit(1); // 1: 비정상 종료
		}
		finally {
			// 마무리 작업 수행
			// 위에서 종료했기 때문에 나오지 않는다.
			System.out.println("프로그램 종료 전에 마무리 작업을 수행합니다.");
		}
	}
	// static 이므로 따로 인스턴스 생성 안하고 바로 가져다 사용 가능
	public static int divide(int num1, int num2) {
		return num1 / num2;
	}

}

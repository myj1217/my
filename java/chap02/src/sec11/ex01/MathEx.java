package sec11.ex01;

public class MathEx {

	public static void main(String[] args) {
		// 절댓값
        int absoluteValue = Math.abs(-10);
        System.out.println("절댓값: " + absoluteValue);

        // 최댓값
        int maxNumber = Math.max(5, 9);
        System.out.println("최댓값: " + maxNumber);

        // 올림
        double ceilValue = Math.ceil(3.2);
        System.out.println("올림: " + ceilValue);

        // 내림
        double floorValue = Math.floor(3.8);
        System.out.println("내림: " + floorValue);

        // 반올림
        long roundedValue = Math.round(3.5);
        System.out.println("반올림: " + roundedValue);

        // 가까운 정수의 실수값
        double rintValue = Math.rint(4.3);
        double rintValue2 = Math.rint(4.8);
        System.out.println("가까운 정수의 실수 값: " + rintValue);
        System.out.println("가까운 정수의 실수 값: " + rintValue2);
	}

}

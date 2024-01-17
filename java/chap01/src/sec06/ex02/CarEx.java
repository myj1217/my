package sec06.ex02;

public class CarEx {

	public static void main(String[] args) {
		// 객체 생성
		Car myCar = new Car();
		
		// 필드 사용
		System.out.println("구매 회사: "+ myCar.company);
		System.out.println("색상: "+ myCar.color);
		System.out.println("좌석수: "+ myCar.seat);
		System.out.println("연료: "+ myCar.fuel);
		
		// 필드값 변경
		myCar.color = "red";
		System.out.println("색상: "+ myCar.color + "로 변경하였습니다.");
	}

}

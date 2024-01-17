package sec06.ex04;

public class ConstructorsEx01 {
	int x; // 클래스 속성 만들기
	
	// 기본 클래스에 대한 클래스 생성자 작성
	public ConstructorsEx01() {
		x = 5; // 클래스 속성의 초기값 설정
	}
	public static void main(String[] args) {
		ConstructorsEx01 myObj = new ConstructorsEx01(); // 생성자 객체 생성
		System.out.println(myObj.x);

	}

}

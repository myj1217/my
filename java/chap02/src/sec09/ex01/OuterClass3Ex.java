package sec09.ex01;

import sec09.ex01.OuterClass3.StaticInnerClass;

public class OuterClass3Ex {

	public static void main(String[] args) {
		// 정적 중첩 클래스의 인스턴스 생성
		StaticInnerClass staticInnerObj = new StaticInnerClass();
		
		// 정적 중첩 클래스의 정적 메서드 호출
		StaticInnerClass.innerStaticMethod();
	}

}

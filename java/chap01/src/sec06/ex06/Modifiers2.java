package sec06.ex06;

public class Modifiers2 {
	public Modifiers2() {
		Modifiers modi = new Modifiers();
		modi.field1 = 1;
		modi.field2 = 2;
//		modi.field3 = 3; // private 접근제한자 이므로 에러
		
		modi.method1();
		modi.method2();
//		modi.method3(); // private 접근제한자 이므로 에러
	}
}

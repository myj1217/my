package sec09.ex03;

public class ParentEx {

	public static void main(String[] args) {
		Parent parent = new Parent() {
			@Override
			public void doSomething() {
				System.out.println("익명 자식 클래스 입니다.");
			}
		};
		
		parent.doSomething();
	}

}

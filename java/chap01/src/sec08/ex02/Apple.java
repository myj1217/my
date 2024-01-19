package sec08.ex02;

class Apple implements Fruit {
	@Override
	public void eat() {
		System.out.println("사과를 먹습니다.");
	}
	
	public void peel() {
		System.out.println("사과 껍질을 벗깁니다.");
	}
}

package sec08.ex02;

class Banana implements Fruit {
	
	@Override
	public void eat() {
		System.out.println("바나나를 먹습니다.");
	}
	
	public void peel() {
		System.out.println("바나나 껍질을 벗깁니다.");
	}

}

package sec07.ex02;

class Airplane {
	public void fly() {
		System.out.println("Airplane is flying.");
	}
}

class Jet extends Airplane {
	@Override
	public void fly() {
		System.out.println("제트기는 초음속으로 날고 있습니다.");
	}
	
	public void afterburner() {
		System.out.println("제트는 추가 추력을 위해 애프터버너를 사용합니다.");
	}
}

public class CastingEx {

	public static void main(String[] args) {
		Airplane airplane = new Jet();
		
		airplane.fly();
		// airplane.afterburner();
		
		Jet jet = (Jet) airplane;
		jet.afterburner();
	}

}

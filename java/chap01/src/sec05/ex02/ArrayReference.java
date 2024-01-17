package sec05.ex02;

class Study {
	private String name;
	
	public Study(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

public class ArrayReference {

	public static void main(String[] args) {
		Study[] subject = new Study[3]; // 3개를 만들 수 있는 공간을 만들었다.
		
		subject[0] = new Study("mathematics");
		subject[1] = new Study("Science");
		subject[2] = new Study("English");
		
		for (Study study: subject) {
			System.out.println(study.getName());
		}
	}

}

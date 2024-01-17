package sec05.ex01;

public class NullPointEx {

	public static void main(String[] args) {
		String str = null;
		
		// NullPointException 발생
		int length = str.length();
		
		// 객체 생성 후 참조 변수에 null 할당
		Job job = new Job();
		job = null;
		
		// NullPointerException 발생
		String name = job.getName();
	}

}

class Job {
	private String name;
	
	public String getName() {
		return name;
	}
}
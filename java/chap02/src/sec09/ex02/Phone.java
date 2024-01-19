package sec09.ex02;

public class Phone {
	private String brand;
	
	public Phone(String brand) {
		this.brand = brand;
	}
	
	public void makeCall(String number) {
		System.out.println(number + "번호로 전화를 합니다.");
	}
	
	public static class Camera implements CameraInterface {
		@Override
		public void takePhoto() {
			System.out.println("사진을 찍습니다.");
		}
		
		@Override
		public void recordVideo() {
			System.out.println("비디오를 찍습니다.");
		}
	}
	
	public interface CameraInterface {
		void takePhoto();
		void recordVideo();
	}
}

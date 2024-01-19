package sec09.ex02;

public class PhoneEx {

	public static void main(String[] args) {
		Phone.Camera camera = new Phone.Camera();
		
		Phone samsung = new Phone("Galaxy");
		samsung.makeCall("010-2222-2580");
		
		camera.takePhoto();
		camera.recordVideo();
		
		Phone apple = new Phone("iPhone");
		apple.makeCall("010-5555-2580");
		
		camera.takePhoto();
		camera.recordVideo();
	}

}

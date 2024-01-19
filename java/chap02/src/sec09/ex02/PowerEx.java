package sec09.ex02;

public class PowerEx {

	public static void main(String[] args) {
		PowerController powerController = new PowerController();
		
		// 전원이 켜지면서 인디케이터 상태 확인
		powerController.turnOn();
		powerController.showPowerOn();
		
		// 전원이 꺼지면서 인디케이터 상태 확인
		powerController.turnOff();
	}

}

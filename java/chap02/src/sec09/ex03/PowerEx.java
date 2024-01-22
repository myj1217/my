package sec09.ex03;

public class PowerEx {

	public static void main(String[] args) {
		PowerController powerController = new PowerController(0);
		
		powerController.checkBattery(new PowerController.BatteryIndicator() {
			
			@Override
			public int getBatteryLevel() {
				return 75;
			}
		});
	}

}

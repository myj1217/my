package sec09.ex03;

public class PowerController {
	private int batteryLevel;
	
	public PowerController(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	
	public void turnOn() {
		System.out.println("전원을 킵니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	
	interface BatteryIndicator {
		int getBatteryLevel();
	}
	
	public void checkBattery(BatteryIndicator batteryIndicator) {
		int level = batteryIndicator.getBatteryLevel();
		System.out.println("배터리 용량: " + level);
	}
}

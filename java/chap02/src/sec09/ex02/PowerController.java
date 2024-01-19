package sec09.ex02;

public class PowerController implements PowerSwitch, PowerSwitch.Indicator {
	private boolean isPowerOn;
	
	@Override
	public void turnOn() {
		isPowerOn = true;
		System.out.println(isPowerOn);
	}
	
	@Override
	public void turnOff() {
		isPowerOn = false;
		showPowerOff();
	}
	
	@Override
	public void showPowerOn() {
		System.out.println("화면 on");
	}
	
	@Override
	public void showPowerOff() {
		System.out.println("화면 off");
	}
}

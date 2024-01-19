package sec09.ex02;

public interface PowerSwitch {
	void turnOn();
	void turnOff();
	
	public interface Indicator {
		void showPowerOn();
		void showPowerOff();
	}
}

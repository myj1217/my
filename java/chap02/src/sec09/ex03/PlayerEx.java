package sec09.ex03;

public class PlayerEx {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		
		Speaker speaker = new Speaker() {
			@Override
			public void playSound() {
				System.out.println("재생중...");
			}
		};
		
		audioPlayer.playMusic(speaker);
	}

}

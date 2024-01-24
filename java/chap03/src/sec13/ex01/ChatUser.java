package sec13.ex01;

public class ChatUser extends Thread {
	private String name;
	private ChatRoom chatRoom;
	
	public ChatUser(String name, ChatRoom chatRoom) {
		this.name = name;
		this.chatRoom = chatRoom;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String message = name + "의 메시지 " + i;
			chatRoom.addMessage(message);
			System.out.println(name + "이 보낸 메시지 " + message);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

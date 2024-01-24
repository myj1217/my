package sec13.ex01;

import java.util.*;

public class VectorEx {

	public static void main(String[] args) {
		ChatRoom chatRoom = new ChatRoom();
		
		ChatUser user1 = new ChatUser("User1", chatRoom);
		ChatUser user2 = new ChatUser("User2", chatRoom);
		
		user1.start();
		user2.start();
		
		try {
			// join: 기다리는 것
			user1.join();
			user2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Vector<String> messages = chatRoom.getMessages();
		System.out.println("메시지 출력: ");
		for (String message: messages) {
			System.out.println(message);
		}
		
		int randomIndex = new Random().nextInt(messages.size());
		chatRoom.removeMessage(randomIndex);
		System.out.println("\n인덱스에서 메시지 제거 " + randomIndex);
		
		messages = chatRoom.getMessages();
		System.out.println("\n남은 메시지: ");
		for (String message: messages) {
			System.out.println(message);
		}
	}

}

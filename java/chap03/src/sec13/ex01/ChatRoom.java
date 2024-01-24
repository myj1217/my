package sec13.ex01;

import java.util.Vector;

public class ChatRoom {
	// 메시지를 순서대로 처리하귀 위해 Vector 생성
	private Vector<String> messages;
	public ChatRoom() {
	
		messages = new Vector<>();
	}
	
	// 순서대로 추가
	public synchronized void addMessage(String message) {
		messages.add(message);
	}
	
	// 순서대로 삭제
	public synchronized void removeMessage(int index) {
		// 유효성 검사
		if (index >= 0 && index < messages.size()) {
			messages.remove(index);
		}
	}
	
	// 순서대로 값 얻기
	public synchronized Vector<String> getMessages() {
		return new Vector<>(messages);
	}
}

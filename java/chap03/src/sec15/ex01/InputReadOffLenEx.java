package sec15.ex01;

import java.io.FileInputStream;
import java.io.IOException;

public class InputReadOffLenEx {

	public static void main(String[] args) {
		String fileName = "output.txt";
		
		try (FileInputStream inputStream = new FileInputStream(fileName)) {
			byte[] buffer = new byte[5]; // 읽어올 최대 길이를 5로 설정
			int bytesRead = inputStream.read(buffer, 0, 5); // 최대 5바이트 읽어옴
			
			// bytesRead: 실제로 읽어온 바이트 수
			if (bytesRead != -1) {
				// buffer의 0번 인덱스부터 bytesRead의 길이만큼 문자열로 생성
				String content = new String(buffer, 0, bytesRead);
				System.out.println(content); // "Hello" 출력
			}
			// 입력스트림 닫기
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

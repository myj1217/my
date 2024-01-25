package sec15.ex01;

import java.io.FileInputStream;
import java.io.IOException;

public class InputReadArrayEx {

	public static void main(String[] args) {
		String fileName = "output3.txt";
		try (FileInputStream inputStream = new FileInputStream(fileName)) {
			// byte[] buffer = new byte[1]; // 1byte씩 읽어오는 버퍼를 생성
			byte[] buffer = new byte[100]; // 길이가 100인 배열 바이트 생성
			int bytesRead; // 실제로 읽어온 바이트 수
			
			// 읽어온 바이트 수 만큼 버퍼의 내용을 처리하는 작업 수행
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				for (int i = 0; i < bytesRead; i++) { // 읽은 바이트 수 만큼 반복하여
					System.out.print((char) buffer[i]); // 바이트를 문자로 변환하여 출력
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

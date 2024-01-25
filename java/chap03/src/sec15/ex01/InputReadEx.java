package sec15.ex01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputReadEx {

	public static void main(String[] args) {
		try (InputStream inputStream = new FileInputStream("output.txt")) {
			int byteRead;
			while ((byteRead = inputStream.read()) != -1) { // 읽을 게 있다면 = 데이터가 있다면
				// 읽은 바이트(byteRead)를 처리하는 작업을 수행
				System.out.print((char) byteRead); // 바이트를 문자로 변환하여 출력
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

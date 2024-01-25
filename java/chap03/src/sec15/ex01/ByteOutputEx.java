package sec15.ex01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputEx {

	public static void main(String[] args) {
		try {
			// 스트림 생성
			// FileOutputStream 파일로 바이트 데이터를 출력하는 데 사용되는 스트림
			// 파일에 데이터를 쓰기 위해 사용되고 데이터를 바이트 단위로 쓰는 것이므로
			// 텍스트와 바이너리 데이터 모두 쓸 수 있다.
			OutputStream outputStream = new FileOutputStream("output.txt");
			
			// 데이터 출력
			String data = "Hello, OutputStream!";
			byte[] byteData = data.getBytes(); // 문자열을 바이트 배열로 변환
			
			// 데이터를 출력 스트림을 보냄
			outputStream.write(byteData);
			
			// 스트림 닫기
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

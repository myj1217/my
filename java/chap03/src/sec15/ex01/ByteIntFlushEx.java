package sec15.ex01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteIntFlushEx {

	public static void main(String[] args) {
		try {
			// FileOutputStream을 생성하여 파일에 데이터 출력
			OutputStream outputStream = new FileOutputStream("output2.txt");
			
			int data1 = 'H'; // 문자 'H'에 해당하는 아스키코드
			int data2 = 'e';
			int data3 = 'l';
			int data4 = 'o';
			
			// 바이트 데이터를 출력 버퍼에 쓴 후 flush()로 강제 출력
			// 출력 스트림은 출력할 바이트를 내부 버퍼에 우선 저장
			// -> write()로 문자 데이터를 출력 버퍼에 쓴 후 출력 스트림을 닫는다.
			// -> 출력 스트림을 닫을 때 남아있는 출력 버퍼의 내용이 출력되지 않을 수 있다. (유실 가능성)
			// -> 이 때, flush() 메서드를 호출하면 출력 버퍼의 내용이 강제로 출력되므로 원하는 결과를 얻을 수 있다.
			outputStream.write(data1);
			outputStream.write(data2);
			outputStream.write(data3);
			outputStream.write(data4);
			outputStream.flush(); // 빨리 나가!
			
			// 스트림을 닫음
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

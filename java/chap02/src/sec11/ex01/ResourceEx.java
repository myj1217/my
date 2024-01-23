package sec11.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ResourceEx {

	public static void main(String[] args) {
		// 현재 클래스의 클래스 로더를 사용하여 리소스 로드
		URL resourceUrl = Member.class.getResource("data.txt");
		if (resourceUrl != null) {
			System.out.println("Resource URL: " + resourceUrl);
			
			// 리소스 읽기
			// BufferedReader: 버퍼링을 사용하면 한번에 여러 바이트를 읽어와서 메모리에 저장하고
			// 필요할 때마다 버퍼에서 읽어오기 때문에 입출력 효율이 좋다.
			try {
				// 데이터를 임시로 저장하는 곳을 버퍼라고 한다.
				// 데이터를 한 번에 모아서 쏴주는게 더 효율적이다.
				BufferedReader reader = new BufferedReader(new InputStreamReader(resourceUrl.openStream()));
				// 바이트스트림에서 문자스트림으로 바꿔준다.
				// openStream() : URL에서 데이터를 읽어오기 위한
				String line;
				// BufferedReader.readLine()
				while ((line = reader.readLine()) != null) { // readLine() : 한줄씩 읽어들이는 메서드
					System.out.println(line);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Resource not found.");
		}
	}

}

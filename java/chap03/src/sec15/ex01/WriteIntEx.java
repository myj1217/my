package sec15.ex01;

import java.io.FileWriter;
import java.io.IOException;

public class WriteIntEx {

	public static void main(String[] args) {
		String fileName = "unicode.txt";
		
		// 파일에 문자를 쓰는 스트림 (파일에 직접 문자를 쓸 수 있다)
		try (FileWriter writer = new FileWriter(fileName)) {
			int unicode1 = 65;
			int unicode2 = 66;
			int unicode3 = 67;
			
			writer.write(unicode1);
			writer.write(unicode2);
			writer.write(unicode3);
			
			writer.flush();
			writer.close();
			
			System.out.println("File written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

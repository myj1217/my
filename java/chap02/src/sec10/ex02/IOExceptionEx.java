package sec10.ex02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionEx {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일을 읽어오는 동안 예외가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
	}

}

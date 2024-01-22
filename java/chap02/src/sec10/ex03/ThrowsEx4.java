package sec10.ex03;

import java.io.*;

public class ThrowsEx4 {
	public static void main(String[] args) {
		try {
			readFile("file.txt");
		} catch (IOException e) {
			System.out.println("main메서드에서 파일을 읽는 동안 오류가 발생했습니다: " + e.getMessage());
			// throw e; // 컴파일 에러
			// main에 throw를 직접 하는 것은 매우 위험한 행위
			System.exit(1); // 프로그램 종료
		}
	}
	
	public static void readFile(String fileName) throws IOException {
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// 파일을 읽는 작업 수행
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// 파일 내용 처리
			}
			
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("readFile메서드에서 파일을 읽는 동안 오류가 발생했습니다: " + e.getMessage());
			throw e; // 예외를 다시 던져서 상위 호출자에게 처리를 위임
		}
	}
}

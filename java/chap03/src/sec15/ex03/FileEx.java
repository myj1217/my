package sec15.ex03;

import java.io.File;
import java.io.IOException;

public class FileEx {
	// .io로 처리하는 친구들은 IOException 처리를 반드시 해주어야 한다.
	public static void main(String[] args) throws IOException {
		// File 객체 생성
		File file = new File("C:/temp/myfile.txt");
		
		// 파일이 없다면 생성
		if (file.exists() == false) {file.createNewFile();}
		
		// 파일 존재 여부 확인
		if (file.exists()) {
			System.out.println("파일 존재 여부: " + file.getName()); // 파일 이름 반환
			System.out.println("파일 경로: " + file.getAbsolutePath()); // 절대 경로 문자열 반환
			System.out.println("파일 사이즈: " + file.length() + " bytes"); // 파일 크기 반환
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

}

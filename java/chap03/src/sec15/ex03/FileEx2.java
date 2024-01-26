package sec15.ex03;

import java.io.File;

public class FileEx2 {

	public static void main(String[] args) {
		// 파일 객체 생성
		File file = new File("C:/temp/myfile2.txt");
		
		// 파일의 존재 여부 확인
		if (file.exists()) {
			System.out.println("File exists: " + file.getAbsolutePath());
			System.out.println("File size: " + file.length() + " bytes");
		} else {
			System.out.println("파일이 없습니다.");
		}
		
		// 디렉터리 조회
		File directory = new File("C:/temp");
		// isDirectory(): 폴더가 맞는지 확인
		if (directory.isDirectory()) {
			System.out.println("디렉터리 내용: ");
			// listFiles : 디렉토리 내의 파일 및 디렉토리 File 객체 배열 반환
			File[] files = directory.listFiles();
			if (files != null) {
				for (File item: files) {
					System.out.println(item.getName() + (item.isDirectory() ? " (directory)": " (file)"));
				}
			} 
		} else {
			System.out.println("디렉토리가 없습니다.");
		}
	}

}

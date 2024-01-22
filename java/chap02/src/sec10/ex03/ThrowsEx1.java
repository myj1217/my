package sec10.ex03;

import java.io.*;

public class ThrowsEx1 {
	public void readFile(String fileName) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		
		String line;
		// 파일 안에 어떤게 있는지 확인하는 로직
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		ThrowsEx1 example = new ThrowsEx1();
		
		try {
			example.readFile("example.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

}

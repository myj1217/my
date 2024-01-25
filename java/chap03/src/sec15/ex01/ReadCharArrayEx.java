package sec15.ex01;

import java.io.*;

public class ReadCharArrayEx {

	public static void main(String[] args) {
		String fileName = "unicode.txt";
		
		try (Reader reader = new FileReader(fileName)) {
			char [] buffer = new char[100];
			int bytesRead;
			
			while ((bytesRead = reader.read(buffer)) != -1) {
				System.out.println("Read " + bytesRead + " characters: " + new String(buffer, 0, bytesRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

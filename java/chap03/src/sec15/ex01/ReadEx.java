package sec15.ex01;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadEx {

	public static void main(String[] args) {
		String fileName = "unicode.txt";
		
		try (Reader reader = new FileReader(fileName)) {
			int character;
			while ((character = reader.read()) != -1) {
				System.out.println("Character: " + (char) character + " Unicode: " + character);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

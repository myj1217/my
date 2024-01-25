package sec15.ex01;

import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriteEx {

	public static void main(String[] args) {
		String fileName = "char_array_output.txt";
		
		try (FileWriter writer = new FileWriter(fileName)) {
			char[] cbuf = {'H', 'e', 'l', 'l', 'o'};
			writer.write(cbuf);
			
			writer.flush();
			writer.close();
			System.out.println("File written successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

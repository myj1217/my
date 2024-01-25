package sec15.ex01;

import java.io.*;

public class CharConversionEx {

	public static void main(String[] args) {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		
		// String str = new String("java");
		// BufferedReader: 문자 데이터를 버퍼링하여 한줄씩 읽어올 수 있도록 돕는다.
		// InputStreamReader: 바이트 입력 스트림을 문자 입력 스트림으로 변환
		try (BufferedReader reader = new BufferedReader (new InputStreamReader (new FileInputStream(inputFile), "UTF-8"));
				BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream(outputFile), "UTF-8"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
			
			System.out.println("문자 변환을 성공했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

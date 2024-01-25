package sec15.ex01;

import java.io.FileOutputStream;

public class ByteArrayEx01 {

	public static void main(String[] args) {
		byte[] array = {10, 20, 30};
		String filename = "output3.txt";
		
		// byte: -128 ~ 127
		// 부호가 없는 정수로 변환: 0 ~ 255
		
		try (FileOutputStream fos = new FileOutputStream(filename)) {
			for (byte b: array) {
				int value = b & 0xFF; // 바이트를 부호 없는 정수로 변환
				fos.write(Integer.toString(value).getBytes());
				fos.write("\n".getBytes()); // 각 숫자를 새 줄로 구분해서 저장
			}
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
//	public static void main(String[] args) {
//		byte[] array = {10, 20, 30};
//		// 10진수라는 글씨를 얘네들을 모른다.
//		// ex) 10 = 0x10 = 엔터
//		
//		try (OutputStream outputStream = new FileOutputStream("output3.txt")) {
//			for (byte b: array) {
//				outputStream.write(b);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}



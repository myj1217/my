package sec15.ex02;

import java.io.*;

public class PrimitiveDataEx {

	public static void main(String[] args) {
		String fileName = "data.dat";
		
		try (DataOutputStream dos = new DataOutputStream (new FileOutputStream(fileName));
				DataInputStream dis = new DataInputStream (new FileInputStream(fileName))) {
			
			// 데이터를 파일에 쓰기
			dos.writeInt(123);
			dos.writeDouble(3.14);
			dos.writeUTF("Hello, Java!");
			
			// 파일로부터 데이터 읽기
			int intValue = dis.readInt();
			double doubleValue = dis.readDouble();
			String stringValue = dis.readUTF();
			
			System.out.println("Read Integer: " + intValue);
			System.out.println("Read Double: " + doubleValue);
			System.out.println("Read String: " + stringValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

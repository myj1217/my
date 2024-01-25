package sec15.ex01;

public class ReadCharArrayOffsetEx {

	public static void main(String[] args) {
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		//              H    e    l    l    o   공백  J   a   v    a
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4); // offset: 6
		System.out.println(str2);
		
//		String fileName = "output.txt";
//		
//		try (Reader reader = new FileReader(fileName)) {
//			char[] buffer = new char[100]; // 문자를 읽어올 버퍼 생성
//			int offset = 5; // 읽은 문자열을 저장할 배열의 시작 오프셋
//			int length = 10; // 읽을 문자의 길이
//			int bytesRead;
//			
//			while ((bytesRead = reader.read(buffer, offset, length)) != -1) {
//				System.out.println("Read " + bytesRead + " characters: " + new String(buffer, offset, bytesRead));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}

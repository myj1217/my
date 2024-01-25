package sec15.ex01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class OffLenWriteEx {

   public static void main(String[] args) {
      String str = "Hello, OutputStream!";
      try (Writer writer = new FileWriter("off_len_output.txt")) {
          writer.write(str, 0, 5); // str에서 0번부터 5글자만
          writer.flush();
          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
}
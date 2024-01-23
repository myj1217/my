package sec12.ex02;

public class WaitNotifyEx {

   public static void main(String[] args) {
       Message message = new Message();

           // 메시지를 출력하는 스레드
           Thread senderThread = new Thread(() -> {
               String[] messages = {"안녕하세요!", "Hello!", "Bonjour!"};
               for (String msg: messages) {
                   message.send(msg);

                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           });

           // 메시지를 수신하여 출력하는 스레드
           Thread receiverThread = new Thread(() -> {
               for (int i = 0; i < 3; i++) {
                   message.receive();

                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           });

           senderThread.start();
           receiverThread.start();
   }
}
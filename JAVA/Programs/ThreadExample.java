package Programs;
class MessagePrinter implements Runnable {
 private String message;
 public MessagePrinter(String message) {
     this.message = message;
 }
 @Override
 public void run() {
     for (int i = 1; i <= 5; i++) {
         System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
         try {
             Thread.sleep(500);
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted.");
         }
     }
 }
}
public class ThreadExample {
 public static void main(String[] args) {
     MessagePrinter task1 = new MessagePrinter("Hello from Thread 1");
     MessagePrinter task2 = new MessagePrinter("Hello from Thread 2");
          Thread thread1 = new Thread(task1, "Thread-1");
     Thread thread2 = new Thread(task2, "Thread-2");
     thread1.start();
     thread2.start();
 }
}



import org.springframework.core.task.VirtualThreadTaskExecutor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.concurrent.Future;

public class task1 implements Runnable {
  private final String recipient;

  public static void main(String[] args) {
    Future<String> future = executor.submit(() -> {
      String s = "Hello, World!";
      return s.toUpperCase();
    });
    String s="swiss";
    Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
      TreeMap::new, Collectors.counting()));
    System.out.println(executor);
    executor.execute(new task1("Ram"));
    executor.execute(new task1("Shyam"));
    System.out.println(collect);
  }

  static VirtualThreadTaskExecutor executor = new VirtualThreadTaskExecutor();

  public VirtualThreadTaskExecutor getExecutor() {
    System.out.println("Executor: " + executor);
    return executor;
  }

  public task1(String recipient) {
    System.out.println("Creating task for recipient: " + recipient);
    this.recipient = recipient;
  }


  @Override
  public void run() {

    System.out.println("Sending email to " + recipient + " via " + Thread.currentThread().getName());


   /* try {
      // Simulate processing time
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println("Email sent to " + recipient);
  }*/

    String sentence = "Java streams are powerful and expressive";
    String longestWord = java.util.Arrays.stream(sentence.split(""))
      .max(java.util.Comparator.comparingInt(String::length)).get();

    //System.out.println("Longest word: " + longestWord);

  }
}

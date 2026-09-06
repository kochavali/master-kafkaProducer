import org.springframework.core.task.VirtualThreadTaskExecutor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.concurrent.Future;

public class task1 implements Runnable {
  enum Characteristics {
    concurrent,parallel,serial,unordered,ordered,nonblocking,blocking,terminal,intermediate,Identity_Finish
  }
  private final String recipient;

  public static void main(String[] args) {

    String input = "swiss";

    Optional<Character> firstNonRepeating = input.chars()           // IntStream of characters
      .mapToObj(c -> (char) c)                                // Convert IntStream to Stream<Character>
      .collect(Collectors.groupingBy(                         // Group characters by frequency
        Function.identity(),
        LinkedHashMap::new,                             // Maintain original insertion order
        Collectors.counting()
      ))
      .entrySet()
      .stream()                                               // Stream the map entry set
      .filter(entry -> entry.getValue() == 1)                 // Keep only non-repeating characters
      .map(entry -> entry.getKey())                           // Extract the character key
      .findFirst();                                           // Grab the very first one

    // Display results safely using Optional
    firstNonRepeating.ifPresentOrElse(
      ch -> System.out.println("First non-repeating character: " + ch),
      () -> System.out.println("No non-repeating character found.")
    );

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

  }
}

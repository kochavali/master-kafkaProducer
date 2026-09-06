import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    IntStream.range(1, 1000).parallel().forEach(list::add);
    System.out.println(list.size());
    String st="swiss";
    st.chars().mapToObj(c -> (char) c)
      .collect(Collectors.groupingBy(
        c -> c,
        Collectors.counting()
      ))
      .entrySet()
      .stream()
      .filter(entry -> entry.getValue() == 1)
      .map(entry -> entry.getKey())
      .findFirst()
      .ifPresentOrElse(
        ch -> System.out.println("First non-repeating character: " + ch),
        () -> System.out.println("No non-repeating character found.")
      );
  }

}

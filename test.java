import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

public class test {
  @Transactional(propagation=REQUIRED,isolation=READ_COMMITTED )
  public static void main(String[] args) {
    List<List<String>> masterlist = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    list1.add("str");
    list1.add("st2");
    List<String> list11 = new ArrayList<>();

    List<String> nonNullItems = list1.stream()
      .filter(Objects::nonNull)
      .collect(Collectors.toList());
    list11.add("wor1");
    list11.add("wor2");
    masterlist.add(list1);
    masterlist.add(list11);
    System.out.println(masterlist);
    //IntStream.range(1, 1000).parallel().forEach(list::add);
    System.out.println(masterlist.size());
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
    Integer a=128;
    System.out.println(a.toString());
    Integer b=128;
    System.out.println(a!=b);
  }


}

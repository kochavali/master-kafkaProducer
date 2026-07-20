import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
@SpringBootApplication
public class ThreadSampleExecutorsKafkaProducer {

      public static void main(String[] args) throws InterruptedException, ExecutionException {

        task1 task1=new task1("Ram's task 1");
        task11 task11=new task11("Syam's task 2");
        //task1.run();
          ExecutorService executorService= Executors.newFixedThreadPool(1);
        System.out.println(executorService.invokeAll(
                List.of(
                        () -> {
                            System.out.println(task1);
                            return null;
                        },
                        () -> {
                            System.out.println("Task 2");
                            return null;
                        },
                        () -> {
                            System.out.println("Task 3");
                            return null;
                        }
                )));
          Callable c=new Callable() {
              String s=new String("java");
              @Override
              public String call() throws Exception {
                ArrayList list = new ArrayList();
                ArrayList list1 = new ArrayList();
                ArrayList list12 = new ArrayList();
                list.add("Rama");
                list.add("Shyam");
                list.add("Mohan");
                list.add("Sohan");
                list.add("Ram");
                Set<String> set = new HashSet<>();
                Set<String> duplicates = new HashSet<>();
               /* for (String name : list) {
                  if (!set.add( name)) {
                    duplicates.add((String) name);
                  }
                }*/
                System.out.println("Duplicate names: " + duplicates);
                  return s;
              }
          };
          Future f=executorService.submit(c);
          try {
              System.out.println(f.get());
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          } catch (ExecutionException e) {
              throw new RuntimeException(e);
          }
      }
}

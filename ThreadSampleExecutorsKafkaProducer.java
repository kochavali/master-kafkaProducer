import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.*;
@SpringBootApplication
public class ThreadSampleExecutorsKafkaProducer {

      public static void main(String[] args) throws InterruptedException {

        task1 task1=new task1("Ram's task 1");
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

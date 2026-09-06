import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.Executor;

public class task11 implements Serializable {
  private static Executor executor;
  private final String recipient;
  public static void main(String[] args) throws IOException {
    task11.executor.execute(new task1("Shyam"));
    ObjectOutputStream oos = null;
    oos.writeObject(executor);
  }



  public String getExecutor() {
    System.out.println("Executor: " + executor);
   return executor.toString();
    //return null;
  }
  public task11(String recipient) {
    System.out.println("Creating task for recipient: " + recipient);
    this.recipient = recipient;

  }
}

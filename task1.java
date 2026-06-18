public class task1 implements Runnable{
  private final String recipient;

  public task1(String recipient) {
    this.recipient = recipient;
  }


  @Override
  public void run() {
    System.out.println("Sending email to " + recipient + " via " + Thread.currentThread().getName());
    try {
      // Simulate processing time
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println("Email sent to " + recipient);
  }
}

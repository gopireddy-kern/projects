class EmailService extends Thread {

    private String email;

    public EmailService(String email) {
        this.email = email;
    }

    @Override
    public void run() {
        try {
            System.out.println("Preparing email to: " + email);
            
            Thread.sleep(3000);
            
            System.out.println("Email successfully sent to: " + email);
        } catch (InterruptedException e) {
            System.out.println("Email sending interrupted");
        }
    }
}

public class EmailNotificationSystem {

    public static void main(String[] args) {

        System.out.println("Order placed successfully!");

        EmailService emailThread = new EmailService("customer@gmail.com");
        emailThread.start();

        System.out.println("Order confirmation displayed to user.");
        System.out.println("Main thread continues processing...");
    }
}

import java.util.Random;

class PaymentTask implements Runnable {

    private String paymentId;

    public PaymentTask(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            System.out.println(Thread.currentThread().getName() +
                    " - Payment " + paymentId + " verification started.");

            int delay = 1000 + random.nextInt(2000);
            Thread.sleep(delay);

            System.out.println(Thread.currentThread().getName() +
                    " - Payment " + paymentId + " completed in "
                    + (delay / 1000.0) + " seconds.\n");

        } catch (InterruptedException e) {
            System.out.println("Payment interrupted: " + paymentId);
        }
    }
}

public class PaymentGatewaySimulation {

    public static void main(String[] args) {
        Thread p1 = new Thread(new PaymentTask("TXN-101"));
        Thread p2 = new Thread(new PaymentTask("TXN-102"));
        Thread p3 = new Thread(new PaymentTask("TXN-103"));

        p1.setName("Payment-Thread-1");
        p2.setName("Payment-Thread-2");
        p3.setName("Payment-Thread-3");

        p1.start();
        p2.start();
        p3.start();
    }
}

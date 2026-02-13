
class Order implements Runnable {

    private int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        try {
            validateOrder();
            processPayment();
            completeOrder();
        } catch (InterruptedException e) {
            System.out.println("Order " + orderId + " interrupted.");
        }
    }

    private void validateOrder() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +
                " - Validating Order " + orderId);
        Thread.sleep(1000); 
    }

    private void processPayment() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +
                " - Processing Payment for Order " + orderId);
        Thread.sleep(1500); 
    }

    private void completeOrder() {
        System.out.println(Thread.currentThread().getName() +
                " - Order " + orderId + " Completed Successfully.\n");
    }
}

public class OrderProcessingSystem {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            Order order = new Order(i);

            Thread thread = new Thread(order);
            thread.setName("Order-Thread-" + i);

            thread.start(); 
        }
    }
}

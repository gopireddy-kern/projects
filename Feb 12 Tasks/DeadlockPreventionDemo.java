
class PaymentService {
    public void processPayment(String orderId) {
        System.out.println(Thread.currentThread().getName() +
                " processing payment for Order " + orderId);
    }
}

class InventoryService {
    public void reserveItem(String orderId) {
        System.out.println(Thread.currentThread().getName() +
                " reserving inventory for Order " + orderId);
    }
}

class OrderTask implements Runnable {

    private final Object paymentLock;
    private final Object inventoryLock;
    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    private final String orderId;

    public OrderTask(Object paymentLock,
                     Object inventoryLock,
                     PaymentService paymentService,
                     InventoryService inventoryService,
                     String orderId) {
        this.paymentLock = paymentLock;
        this.inventoryLock = inventoryLock;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
        this.orderId = orderId;
    }

    @Override
    public void run() {

        synchronized (paymentLock) {

            System.out.println(Thread.currentThread().getName()
                    + " locked Payment for Order " + orderId);

            sleep();

            synchronized (inventoryLock) {

                System.out.println(Thread.currentThread().getName()
                        + " locked Inventory for Order " + orderId);

                paymentService.processPayment(orderId);
                inventoryService.reserveItem(orderId);

                System.out.println("✅ Order " + orderId + " completed\n");
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class DeadlockPreventionDemo {

    public static void main(String[] args) {

        Object paymentLock = new Object();
        Object inventoryLock = new Object();

        PaymentService paymentService = new PaymentService();
        InventoryService inventoryService = new InventoryService();

        Thread t1 = new Thread(
                new OrderTask(paymentLock, inventoryLock,
                        paymentService, inventoryService, "101"));

        Thread t2 = new Thread(
                new OrderTask(paymentLock, inventoryLock,
                        paymentService, inventoryService, "102"));

        Thread t3 = new Thread(
                new OrderTask(paymentLock, inventoryLock,
                        paymentService, inventoryService, "103"));

        t1.start();
        t2.start();
        t3.start();
    }
}


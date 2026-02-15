import java.util.concurrent.*;

class Order {
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}

class OrderProducer implements Runnable {

    private BlockingQueue<Order> queue;

    public OrderProducer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                Order order = new Order("ORD-" + i);
                queue.put(order); 
                System.out.println("Produced: " + order.getOrderId());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class OrderConsumer implements Runnable {

    private BlockingQueue<Order> queue;

    public OrderConsumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = queue.take(); 
                System.out.println("Processing: " + order.getOrderId()
                        + " by " + Thread.currentThread().getName());
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer stopped.");
        }
    }
}

public class OrderProcessingSystem {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Order> queue = new ArrayBlockingQueue<>(10);

        Thread producerThread = new Thread(new OrderProducer(queue));
        producerThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new OrderConsumer(queue));
        executor.submit(new OrderConsumer(queue));

        Thread.sleep(15000);

        executor.shutdownNow();
        producerThread.interrupt();

        System.out.println("Order Processing System Stopped.");
    }
}


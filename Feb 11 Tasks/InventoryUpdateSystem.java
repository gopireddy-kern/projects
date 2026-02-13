class Inventory {

    private int stock = 100;   

    public void updateStock(String workerName, int quantity) {

        System.out.println(workerName + " is preparing to update stock...");

        synchronized (this) {
            System.out.println(workerName + " updating stock...");

            if (stock >= quantity) {
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stock -= quantity;
                System.out.println(workerName + " updated stock by -" + quantity);
                System.out.println("Remaining Stock: " + stock);
            } else {
                System.out.println("Insufficient stock for " + workerName);
            }
        }
        System.out.println(workerName + " finished update process.\n");
    }
}

class Worker extends Thread {

    private Inventory inventory;
    private int quantity;

    public Worker(Inventory inventory, String name, int quantity) {
        super(name);
        this.inventory = inventory;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        inventory.updateStock(Thread.currentThread().getName(), quantity);
    }
}

public class InventoryUpdateSystem {

    public static void main(String[] args) {

        Inventory sharedInventory = new Inventory();  // Shared resource

        Worker w1 = new Worker(sharedInventory, "Worker-1", 30);
        Worker w2 = new Worker(sharedInventory, "Worker-2", 50);
        Worker w3 = new Worker(sharedInventory, "Worker-3", 40);

        w1.start();
        w2.start();
        w3.start();
    }
}


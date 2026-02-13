import java.time.LocalTime;

class LoginTask implements Runnable {

    private String userName;

    public LoginTask(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " - Login started for " + userName +
                    " at " + LocalTime.now());

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() +
                    " - Login SUCCESS for " + userName +
                    " at " + LocalTime.now());

        } catch (InterruptedException e) {
            System.out.println("Login interrupted for " + userName);
        }
    }
}

public class MultiUserLoginSystem {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];

        System.out.println("===== Before Starting Threads =====");

        for (int i = 0; i < 10; i++) {
            LoginTask task = new LoginTask("User-" + (i + 1));
            threads[i] = new Thread(task);
            threads[i].setName("Login-Thread-" + (i + 1));

            System.out.println(threads[i].getName() +
                    " State: " + threads[i].getState());
        }

        System.out.println("\n===== Starting Threads =====");

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("\n===== After Execution =====");

        for (int i = 0; i < 10; i++) {
            System.out.println(threads[i].getName() +
                    " State: " + threads[i].getState());
        }
    }
}


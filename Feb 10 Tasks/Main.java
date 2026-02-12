import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class Logger {

    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

interface Service {
    void execute();
}

class UserService implements Service {

    @LogExecutionTime
    public void createUser() {
        try {
            Thread.sleep(200); 
        } catch (Exception e) {}
        System.out.println("User created");
    }

    public void execute() {
        createUser();
    }
}

class OrderService implements Service {

    @LogExecutionTime
    public void placeOrder() {
        try {
            Thread.sleep(300); 
        } catch (Exception e) {}
        System.out.println("Order placed");
    }

    public void execute() {
        placeOrder();
    }
}

class FrameworkExecutor {

    public static void run(Service service) throws Exception {

        Logger logger = Logger.getInstance();
        Class<?> clazz = service.getClass();

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.currentTimeMillis();
                method.invoke(service);
                long endTime = System.currentTimeMillis();

                logger.log(
                        method.getName() +
                        " executed in " +
                        (endTime - startTime) +
                        " ms"
                );
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Service userService = new UserService();
        Service orderService = new OrderService();

        FrameworkExecutor.run(userService);
        FrameworkExecutor.run(orderService);
    }
}

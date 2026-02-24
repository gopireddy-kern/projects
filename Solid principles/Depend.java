interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}

class UserService {
    private Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void start() {
        database.connect();
    }
}

public class Depend {
    public static void main(String[] args) {
        Database db = new MySQLDatabase();
        UserService service = new UserService(db);
        service.start();
    }
}

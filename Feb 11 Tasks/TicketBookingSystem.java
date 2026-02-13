class TicketCounter {

    int availableTickets = 10;  

    public void bookTicket(String userName, int ticketsRequested) {

        System.out.println(userName + " is trying to book " + ticketsRequested + " tickets.");

        if (availableTickets >= ticketsRequested) {

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            availableTickets -= ticketsRequested;

            System.out.println(userName + " successfully booked " + ticketsRequested + " tickets.");
            System.out.println("Remaining Tickets: " + availableTickets + "\n");
        } else {
            System.out.println("Not enough tickets for " + userName + "\n");
        }
    }
}

class User extends Thread {

    TicketCounter counter;
    int tickets;

    public User(TicketCounter counter, String name, int tickets) {
        super(name);
        this.counter = counter;
        this.tickets = tickets;
    }

    public void run() {
        counter.bookTicket(getName(), tickets);
    }
}

public class TicketBookingSystem {

    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        User u1 = new User(counter, "User-1", 3);
        User u2 = new User(counter, "User-2", 4);
        User u3 = new User(counter, "User-3", 2);
        User u4 = new User(counter, "User-4", 3);
        User u5 = new User(counter, "User-5", 2);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
    }
}

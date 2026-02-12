
import java.util.*;

class Movie {
    private String title;
    private int totalSeats;
    private Map<String, Double> seatCategories; 
    private Map<String, List<String>> bookingHistory; 
    private int seatsBooked = 0;

    public Movie(String title, int totalSeats) {
        this.title = title;
        this.totalSeats = totalSeats;
        this.seatCategories = new HashMap<>();
        this.bookingHistory = new HashMap<>();
    }

    public void addSeatCategory(String category, double price) {
        seatCategories.put(category, price);
    }

    public void displaySeatCategories() {
        System.out.println("Seat Categories for " + title + ":");
        seatCategories.forEach((cat, price) -> System.out.println(cat + " - ₹" + price));
    }

    public synchronized boolean bookTickets(String user, String category, int numberOfSeats) {
        if (numberOfSeats <= 0) return false;

        if (seatsBooked + numberOfSeats > totalSeats) {
            System.out.println("Sorry " + user + ", not enough seats available.");
            return false;
        }

        seatsBooked += numberOfSeats;
        bookingHistory.putIfAbsent(user, new ArrayList<>());
        for (int i = 1; i <= numberOfSeats; i++) {
            bookingHistory.get(user).add(category + " Seat#" + seatsBooked);
        }

        double totalPrice = seatCategories.getOrDefault(category, 0.0) * numberOfSeats;
        System.out.println(user + " booked " + numberOfSeats + " " + category + " seat(s). Total: ₹" + totalPrice);
        return true;
    }

    public void showBookingHistory() {
        System.out.println("\nBooking History for " + title + ":");
        bookingHistory.forEach((user, seats) -> {
            System.out.println(user + " booked: " + seats);
        });
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}

class User implements Runnable {
    private String name;
    private Movie movie;
    private String category;
    private int seatsToBook;

    public User(String name, Movie movie, String category, int seatsToBook) {
        this.name = name;
        this.movie = movie;
        this.category = category;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        movie.bookTickets(name, category, seatsToBook);
    }
}

public class MovieBookingSystemDemo {

    public static void main(String[] args) throws InterruptedException {

        Movie movie = new Movie("Avengers: Endgame", 10);

        movie.addSeatCategory("VIP", 500);
        movie.addSeatCategory("Premium", 300);
        movie.addSeatCategory("Regular", 150);

        movie.displaySeatCategories();
        Thread user1 = new Thread(new User("Alice", movie, "VIP", 3));
        Thread user2 = new Thread(new User("Bob", movie, "Premium", 4));
        Thread user3 = new Thread(new User("Charlie", movie, "Regular", 5));

        user1.start();
        user2.start();
        user3.start();

        user1.join();
        user2.join();
        user3.join();

        movie.showBookingHistory();

        System.out.println("\nTotal seats booked: " + movie.getSeatsBooked() + "/" + movie.getTotalSeats());
    }
}


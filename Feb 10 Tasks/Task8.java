import java.util.*;

/* =========================
   Custom Exception
   ========================= */
class BookUnavailableException extends Exception {
    public BookUnavailableException(String message) {
        super(message);
    }
}

/* =========================
   Book Class (Encapsulation)
   ========================= */
class Book {

    private int id;
    private String title;
    private String author;
    private boolean available = true;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public void issue() throws BookUnavailableException {
        if (!available) {
            throw new BookUnavailableException("Book is not available");
        }
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Title: " + title +
               ", Author: " + author +
               ", Available: " + available;
    }
}

/* =========================
   Member Class
   ========================= */
class Member {

    private int memberId;
    private String name;
    private Map<Book, Date> issuedBooks = new HashMap<>();

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void issueBook(Book book) throws BookUnavailableException {
        book.issue();
        issuedBooks.put(book, new Date());
        System.out.println(name + " issued " + book.getTitle());
    }

    public void returnBook(Book book) {
        Date issueDate = issuedBooks.remove(book);
        book.returnBook();

        // Bonus: Late fine calculation
        if (issueDate != null) {
            long days =
                (System.currentTimeMillis() - issueDate.getTime())
                / (1000 * 60 * 60 * 24);

            if (days > 7) {
                long fine = (days - 7) * 5;
                System.out.println("Late fine: ₹" + fine);
            }
        }

        System.out.println(name + " returned " + book.getTitle());
    }
}

class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id)
                return b;
        }
        return null;
    }

    /* Sort by Title */
    public void sortByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

    public void sortByAuthor() {
        books.sort(Comparator.comparing(Book::getAuthor));
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}

public class task8 {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "Clean Code", "Robert Martin"));
        library.addBook(new Book(3, "Effective Java", "Joshua Bloch"));

        Member member = new Member(101, "Ravi");

        try {
            Book book = library.findBook(2);
            member.issueBook(book);

            member.issueBook(book);

        } catch (BookUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Book book = library.findBook(2);
        member.returnBook(book);

        System.out.println("\nBooks sorted by Title:");
        library.sortByTitle();
        library.displayBooks();

        System.out.println("\nBooks sorted by Author:");
        library.sortByAuthor();
        library.displayBooks();
    }
}


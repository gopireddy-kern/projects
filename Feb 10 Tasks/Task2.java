import java.util.*;

interface Product {
    String getName();
    double getPrice();
}

class Electronics implements Product {

    private String name;
    private double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class Clothing implements Product {

    private String name;
    private double price;

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class Groceries implements Product {

    private String name;
    private double price;

    public Groceries(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}

class FestivalDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.90; // 10% off
    }
}

class PremiumCustomerDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.80; // 20% off
    }
}

class Cart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotal() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void sortByPrice() {
        products.sort(Comparator.comparing(Product::getPrice));
    }

    public void displayCart() {
        products.forEach(p ->
                System.out.println(p.getName() + " - ₹" + p.getPrice())
        );
    }
}


public class Task2 {

    public static void main(String[] args) {

        Cart cart = new Cart();

        cart.addProduct(new Electronics("Laptop", 60000));
        cart.addProduct(new Clothing("Jacket", 3000));
        cart.addProduct(new Groceries("Rice Bag", 1200));

        System.out.println("Cart Items:");
        cart.displayCart();

        double total = cart.calculateTotal();
        System.out.println("\nTotal Amount: ₹" + total);

        DiscountStrategy discount = new FestivalDiscount();
        double finalAmount = discount.applyDiscount(total);

        System.out.println("After Discount: ₹" + finalAmount);

        System.out.println("\nCart Items Sorted by Price:");
        cart.sortByPrice();
        cart.displayCart();
    }
}


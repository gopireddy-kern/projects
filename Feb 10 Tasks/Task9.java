import java.io.*;
import java.util.*;
import java.util.stream.*;

final class Product {

    private int id;
    private String name;
    private int stock;

    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        setStock(stock);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Stock: " + stock;
    }
}

class InventoryManager {

    private final Map<Integer, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public void updateStock(int id, int newStock) {
        Product product = productMap.get(id);
        if (product != null) {
            product.setStock(newStock);
        }
    }

    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    public Product search(int id) {
        return productMap.get(id);
    }

    public List<Product> search(String name) {
        return productMap.values()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void generateReport() {
        System.out.println("\n--- Stock Report ---");
        productMap.values()
                .stream()
                .sorted(Comparator.comparing(Product::getStock).reversed())
                .forEach(System.out::println);
    }

    public void exportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Product product : productMap.values()) {
                writer.println(product);
            }
            System.out.println("\nStock summary exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}

public class Task9 {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 10));
        manager.addProduct(new Product(102, "Mouse", 50));
        manager.addProduct(new Product(103, "Keyboard", 30));

        manager.updateStock(101, 8);

        System.out.println("\nSearch by ID:");
        System.out.println(manager.search(102));

        System.out.println("\nSearch by Name:");
        manager.search("Mouse").forEach(System.out::println);

        manager.generateReport();

        manager.deleteProduct(103);

        manager.exportToFile("stock_report.txt");
    }
}


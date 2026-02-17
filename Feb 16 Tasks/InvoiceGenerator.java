public class InvoiceGenerator {

    public static void main(String[] args) {

        String customerName = "Ravi";
        int invoiceNumber = 101;
        double item1Price = 500.00;
        double item2Price = 1200.00;

        double total = item1Price + item2Price;

        StringBuilder invoice = new StringBuilder();

        invoice.append("------------ INVOICE ------------\n");
        invoice.append("Invoice No : ").append(invoiceNumber).append("\n");
        invoice.append("Customer   : ").append(customerName).append("\n");
        invoice.append("---------------------------------\n");
        invoice.append("Item 1     : ₹").append(item1Price).append("\n");
        invoice.append("Item 2     : ₹").append(item2Price).append("\n");
        invoice.append("---------------------------------\n");
        invoice.append("Total      : ₹").append(total).append("\n");
        invoice.append("---------------------------------\n");
        invoice.append("Thank You for Your Business!");

        System.out.println(invoice.toString());
    }
}


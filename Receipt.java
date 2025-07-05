import java.util.*;
class Receipt {
    private List<Item> items = new ArrayList<>();
    private double totalTax = 0.0;
    private double totalPrice = 0.0;

    public void addItem(Item item) {
        items.add(item);
        totalTax += item.calculateTax();
        totalPrice += item.getTotalPrice() + item.calculateTax();
    }

    public void printTheReceipt() {
        for (Item item : items) {
            System.out.println(item.getQuantity() + " " + item.getName() + ": " + item.getDisplayPrice());
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", totalTax));
        System.out.println("Total: " + String.format("%.2f", totalPrice));
    }
}

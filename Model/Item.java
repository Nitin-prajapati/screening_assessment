package Model;
public class Item {
    private String name;
    private double price;
    private int quantity;
    private boolean isImported;
    private boolean isExempt;

    public Item(int quantity, String name, double price, boolean isImported, boolean isExempt) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    //use only the getters
    public int getQuantity() { return quantity; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isImported() { return isImported; }
    public boolean isExempt() { return isExempt; }
}
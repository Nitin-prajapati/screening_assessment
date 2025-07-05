class Item {
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

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    public double calculateTax() {
        double taxRate = 0.0;
        if (!isExempt) {
            taxRate += 0.10;
        }
        if (isImported) {
            taxRate += 0.05;
        }
        double tax = taxRate * price;
        return roundTax(tax) * quantity;
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
    }

    public String getName() {
        return (isImported ? "imported " : "") + name.replaceAll("imported", "");
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDisplayPrice() {
        double totalPriceWithTax = getTotalPrice() + calculateTax();
        return String.format("%.2f", totalPriceWithTax);
    }
}
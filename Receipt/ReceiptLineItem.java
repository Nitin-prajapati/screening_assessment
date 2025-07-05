package Receipt;
import Model.*;
import Tax.TaxCalculator;
public class ReceiptLineItem {
    private final Item item;
    private final double tax;

    public ReceiptLineItem(Item item) {
        this.item = item;
        this.tax = TaxCalculator.calculateTax(item);
    }

    public double getTotalPriceWithTax() {
        return item.getQuantity() * item.getPrice() + tax;
    }

    public String getDisplayLine() {
        return item.getQuantity() + " " + (item.isImported() ? "imported " : "") + sanitizeImportedItem(item.getName())
                + ": " + String.format("%.2f", getTotalPriceWithTax());
    }

    public double getTax() {
        return tax;
    }

    private String sanitizeImportedItem (String name) {
        return name.replaceAll("imported","");
    }
}

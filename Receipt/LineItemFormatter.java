package Receipt;

import Model.Item;

public class LineItemFormatter {
    private Item item = null;
    private double tax = 0;

    public LineItemFormatter(Item item,double tax){
        this.item = item;
        this.tax = tax;
    }

    public String getDisplayLine() {
        return item.getQuantity() + " " + (item.isImported() ? "imported " : "") + sanitizeImportedItem(item.getName())
        + ": " + String.format("%.2f", getTotalPriceWithTax());
    }
    
    public double getTotalPriceWithTax() {
        return this.item.getQuantity() * item.getPrice() + tax;
    }
    
    private String sanitizeImportedItem (String name) {
        return name.replaceAll("imported","");
    }
}

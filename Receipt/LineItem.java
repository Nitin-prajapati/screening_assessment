package Receipt;
import Model.*;
public class LineItem {
    private final Item item;
    private final double tax;

    public LineItem(Item item, double tax){
        this.item = item;
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public Item getItem() {
        return this.item;
    }
}

package Receipt;
import java.util.*;

import Model.Item;
public class Receipt {
    private final List<ReceiptLineItem> lineItems = new ArrayList<>();
    private double totalTax = 0.0;
    private double totalPrice = 0.0;

    public void addItem(Item item) {
        ReceiptLineItem lineItem = new ReceiptLineItem(item);
        lineItems.add(lineItem);
        totalTax += lineItem.getTax();
        totalPrice += lineItem.getTotalPriceWithTax();
    }

    public void printTheReceipt() {
        for (ReceiptLineItem lineItem : lineItems) {
            System.out.println(lineItem.getDisplayLine());
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", totalTax));
        System.out.println("Total: " + String.format("%.2f", totalPrice));
    }
}

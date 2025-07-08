package Receipt;
import java.util.*;

import Model.Item;
public class ReceiptPrinter {
    
    private List<LineItem> purchasedLineItems = new ArrayList<>();
    private double totalTax = 0;
    private double totalPrice = 0;
    public ReceiptPrinter(List<LineItem> purchasedLineItems){
        this.purchasedLineItems = purchasedLineItems;
    }

    public void printTheReceipt() {
        for (LineItem lineItem : purchasedLineItems) {
            Item item = lineItem.getItem();
            Double tax = lineItem.getTax();
            printReceiptPerItem(item,tax);
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", this.totalTax));
        System.out.println("Total: " + String.format("%.2f", this.totalPrice));
    }

    private void printReceiptPerItem(Item item, double tax) {
        LineItemFormatter lineItemFormatter = new LineItemFormatter(item,tax);
        this.totalPrice += lineItemFormatter.getTotalPriceWithTax();
        this.totalTax += tax;
        String formattedItemToPrint = lineItemFormatter.getDisplayLine();
        System.out.println(formattedItemToPrint);
    }
}

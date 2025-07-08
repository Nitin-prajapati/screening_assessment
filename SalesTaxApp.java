import java.util.*;

import Input.InputCollector;
import Receipt.ReceiptPrinter;
import Receipt.LineItem;

public class SalesTaxApp {

    public static void main(String[] args) {
        
        InputCollector inputCollector = new InputCollector();
        inputCollector.getUserInputWithTaxCalculated();
        List<LineItem> productsPurchased = inputCollector.getPurchasedProductLineItems();

        ReceiptPrinter receipt = new ReceiptPrinter(productsPurchased);
        receipt.printTheReceipt();
        
    }

}
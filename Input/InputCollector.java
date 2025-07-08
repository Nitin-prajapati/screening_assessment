package Input;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Receipt.LineItem;
import Tax.TaxCalculator;

public class InputCollector {
    private final List<LineItem> productsPurchased = new ArrayList<>();

    public void getUserInputWithTaxCalculated(){
        
        System.out.println("Enter each item (e.g., '1 book at 12.49'), press Enter on a blank line to finish:");
        Scanner scanner = new Scanner(System.in);
        TaxCalculator taxCalculator = new TaxCalculator();
        InputItemParser inputItemParser = new InputItemParser(taxCalculator);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }

            try {
                LineItem lineItem = inputItemParser.parseItemAndCalculateTax(input);
                this.productsPurchased.add(lineItem);
            } catch (Exception e) {
                System.out.println("Invalid input format. Try again.");
            }
        }
        scanner.close();
    }

    public List<LineItem> getPurchasedProductLineItems(){
        return this.productsPurchased;
    }
    
}

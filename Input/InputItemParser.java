package Input;

import Model.Item;
import Receipt.LineItem;
import Tax.TaxCalculator;
import ExemptionChecker.ExemptionChecker;

public class InputItemParser {
    TaxCalculator taxCalculator = null;
    public InputItemParser(TaxCalculator taxCalculator){
        this.taxCalculator = taxCalculator;
    }
    public LineItem parseItemAndCalculateTax(String input) {
        
        Item item = this.splitAndParseInputString(input);
        Double tax = this.taxCalculator.calculateTax(item);

        return new LineItem(item,tax);
    }    

    private Item splitAndParseInputString(String input){
        String[] parts = input.split(" at ");
        double price = Double.parseDouble(parts[1]);
        String[] words = parts[0].split(" ", 2);
        int quantity = Integer.parseInt(words[0]);
        String name = words[1];

        boolean isImported = name.contains("imported");
        boolean isExempt = ExemptionChecker.isExempted(name);

        Item item = new Item(quantity, name, price, isImported, isExempt);
        return item;
    }
}

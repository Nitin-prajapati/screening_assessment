package Input;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Model.Item;
import Receipt.Receipt;

public class InputParser {
    public Receipt handleInput(){
        Receipt receipt = new Receipt();
        System.out.println("Enter each item (e.g., '1 book at 12.49'), press Enter on a blank line to finish:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break;
            }

            try {
                Item item = parseItem(input);
                receipt.addItem(item);
            } catch (Exception e) {
                System.out.println("Invalid input format. Try again.");
            }
        }
        scanner.close();
        return receipt;
    }
    public Item parseItem(String input) {
        
        Set<String> exemptedItems = new HashSet<>(Arrays.asList("book", "books", "chocolate", "chocolates","pills"));

        ///
        /// parsing logic 
        /// divide the input into two part pivot as "at"
        /// left part contains quantity, item name or isImported
        /// right part contains price
        /// 
        String[] parts = input.split(" at ");
        double price = Double.parseDouble(parts[1]);
        String[] words = parts[0].split(" ", 2);
        int quantity = Integer.parseInt(words[0]);
        String name = words[1];
        // System.out.println(name);

        boolean isImported = name.contains("imported");
        boolean isExempt = exemptedItems.stream().anyMatch(name::contains);

        return new Item(quantity, name, price, isImported, isExempt);
    }    
}

import java.util.*;
public class SalesTaxApp {
    private static final Set<String> exemptedItems = new HashSet<>(Arrays.asList("book", "books", "chocolate", "chocolates","pills"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();
        
        System.out.println("Enter each item (e.g., '1 book at 12.49'), press Enter on a blank line to finish:");

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
        System.out.println("\nReceipt:");
        receipt.printTheReceipt();
        scanner.close();
    }

    private static Item parseItem(String input) {
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
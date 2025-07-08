package ExemptionChecker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExemptionChecker {
    private static Set<String> exemptedItems = new HashSet<>(Arrays.asList("book", "books", "chocolate", "chocolates","pills"));

    public static boolean isExempted (String itemName){
        return exemptedItems.stream().anyMatch(itemName::contains);
    }
}

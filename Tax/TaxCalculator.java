package Tax;
import Model.Item;
import Constants.Constants;
public class TaxCalculator {
    private int salesTax = Constants.SALES_TAX;
    private int importDuty = Constants.IMPORT_DUTY;

    public double calculateTax(Item item) {
        double taxRate = 0.0;
        if (!item.isExempt()) taxRate += (this.salesTax/100.00);
        if (item.isImported()) taxRate += (this.importDuty/100.00);

        double rawTax = taxRate * item.getPrice();
        return roundTax(rawTax) * item.getQuantity();
    }

    private static double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
    }
}

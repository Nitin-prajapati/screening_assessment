import Input.InputParser;
import Receipt.Receipt;

public class SalesTaxApp {

    public static void main(String[] args) {
        
        InputParser inputParser = new InputParser();
        
        Receipt receipt = inputParser.handleInput();
        receipt.printTheReceipt();
    }

}
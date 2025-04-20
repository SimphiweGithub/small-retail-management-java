
package RetailInventoryApp;

import java.util.*;


public class RetailInventoryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager(2, 2); 

        
        Electronics laptop = new Electronics("E001", "Gaming Laptop", 10);
        Clothing tshirt = new Clothing("C001", "Cotton T-Shirt", 50);
        inventoryManager.addProduct(laptop, 0, 0); 
        inventoryManager.addProduct(tshirt, 1, 0); 

        while (true) {
            System.out.println("1. Update Stock");
            System.out.println("2. Generate Inventory Report");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID to update stock: ");
                    String productId = scanner.next();
                    System.out.print("Enter quantity to add/remove: ");
                    int quantity = scanner.nextInt();
                    inventoryManager.updateStock(productId, quantity);
                    break;

                case 2:
                    inventoryManager.generateInventoryReport();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; 

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
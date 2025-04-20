
package RetailInventoryApp;


class InventoryManager {
    private Product[][] storeInventory; 

    public InventoryManager(int categories, int subcategories) {
        storeInventory = new Product[categories][subcategories];
    }

    
    public void addProduct(Product product, int categoryIndex, int subcategoryIndex) {
        storeInventory[categoryIndex][subcategoryIndex] = product;
    }


    public void updateStock(String productId, int quantity) {
        for (int i = 0; i < storeInventory.length; i++) {
            for (int j = 0; j < storeInventory[i].length; j++) {
                if (storeInventory[i][j] != null && storeInventory[i][j].getProductId().equals(productId)) {
                    storeInventory[i][j].updateQuantity(quantity);
                    System.out.println("Stock updated for product " + productId + ". New quantity: " + storeInventory[i][j].getQuantity());
                    return;
                }
            }
        }
        System.out.println("Product " + productId + " not found.");
    }

    
    public void generateInventoryReport() {
        System.out.println("=== Inventory Report ===");
        for (int i = 0; i < storeInventory.length; i++) {
            for (int j = 0; j < storeInventory[i].length; j++) {
                if (storeInventory[i][j] != null) {
                    storeInventory[i][j].displayProductDetails();
                }
            }
        }
    }
}
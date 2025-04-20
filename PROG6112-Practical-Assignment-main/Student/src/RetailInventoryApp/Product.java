
package RetailInventoryApp;
import java.util.*;


abstract class Product {
    protected String productId;
    protected String name;
    protected int quantity;

    public Product(String productId, String name, int quantity) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
    }

 
    public abstract void displayProductDetails();

 
    public void updateQuantity(int amount) {
        this.quantity += amount;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
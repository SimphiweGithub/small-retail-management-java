
package RetailInventoryApp;


class Clothing extends Product {
    public Clothing(String productId, String name, int quantity) {
        super(productId, name, quantity);
    }

    @Override
    public void displayProductDetails() {
        System.out.println("Clothing [ID: " + productId + ", Name: " + name + ", Quantity: " + quantity + "]");
    }
}
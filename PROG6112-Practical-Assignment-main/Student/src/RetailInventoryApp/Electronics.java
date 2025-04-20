
package RetailInventoryApp;



class Electronics extends Product {
    public Electronics(String productId, String name, int quantity) {
        super(productId, name, quantity);
    }

    
    @Override
    public void displayProductDetails() {
        System.out.println("Electronics [ID: " + productId + ", Name: " + name + ", Quantity: " + quantity + "]");
    }
}
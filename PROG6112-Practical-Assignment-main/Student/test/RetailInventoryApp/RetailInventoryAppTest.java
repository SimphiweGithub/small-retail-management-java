
package RetailInventoryApp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simphwe Khumalo
 */
public class RetailInventoryAppTest {
    
    private InventoryManager inventoryManager;
    private Electronics laptop;
    private Clothing tshirt;
    
    public RetailInventoryAppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
        inventoryManager = new InventoryManager(2, 2); // 2 categories, 2 subcategories
        laptop = new Electronics("E001", "Gaming Laptop", 10);
        tshirt = new Clothing("C001", "Cotton T-Shirt", 50);

       
        inventoryManager.addProduct(laptop, 0, 0); 
        inventoryManager.addProduct(tshirt, 1, 0); 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class RetailInventoryApp.
     */
    @Test
    public void testUpdateStock() {
        
        inventoryManager.updateStock("E001", 5);
        assertEquals(15, laptop.getQuantity()); // Check if quantity is updated correctly

        
        inventoryManager.updateStock("C001", -10);
        assertEquals(40, tshirt.getQuantity()); // Check if quantity is updated correctly

        
        inventoryManager.updateStock("E999", 10);
        assertEquals(15, laptop.getQuantity()); // Laptop quantity should remain unchanged
    }
    @Test
public void testAddProduct() {
    // Adding products to inventory
    inventoryManager.addProduct(laptop, 0, 0); // Electronics -> Laptops
    inventoryManager.addProduct(tshirt, 1, 0); // Clothing -> T-Shirts

    // Retrieve products to check if they were added correctly
    Product retrievedLaptop = inventoryManager.getProduct(0, 0);
    Product retrievedTshirt = inventoryManager.getProduct(1, 0);
    
    // Verify that the products are not null (i.e., they exist in the inventory)
    assertNotNull(retrievedLaptop);
    assertNotNull(retrievedTshirt);

    // Verify that the products have the correct ID
    assertEquals("E001", retrievedLaptop.getProductId());
    assertEquals("C001", retrievedTshirt.getProductId());
}

@Test
public void testGetProduct() {
    // Add products to the inventory
    inventoryManager.addProduct(laptop, 0, 0);
    inventoryManager.addProduct(tshirt, 1, 0);

    // Test that we can retrieve the products correctly
    assertNotNull(inventoryManager.getProduct(0, 0)); // Should retrieve the laptop
    assertNotNull(inventoryManager.getProduct(1, 0)); // Should retrieve the t-shirt

    // Test retrieving a product from an empty slot
    assertNull(inventoryManager.getProduct(0, 1)); // No product should be here
}
    
}

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;



class ProductsAdminTest {

    @org.junit.jupiter.api.Test

    @Test
    void printInvoice() {
        ProductsAdmin productsAdmin = new ProductsAdmin();
        DecimalFormat df = new DecimalFormat("##.##");
        Map<Product, Integer> shoppingCart = new HashMap<>();
        Product monitor = new Product("Monitor", 164.99, "US", 1.9);
        Product keyboard = new Product("Keyboard", 40.99, "UK", 0.7);
        shoppingCart.put(monitor, 2);
        shoppingCart.put(keyboard, 1);
        productsAdmin.setShoppingCart(shoppingCart);

        Assertions.assertEquals("555.36", productsAdmin.printInvoice());
    }

    @org.junit.jupiter.api.Test
    @Test
    void printInvoice2() {
        ProductsAdmin productsAdmin = new ProductsAdmin();
        DecimalFormat df = new DecimalFormat("##.##");
        Map<Product, Integer> shoppingCart = new HashMap<>();
        Product monitor = new Product("Monitor", 164.99, "US", 1.9);
        Product keyboard = new Product("Keyboard", 40.99, "UK", 0.7);
        Product deskLamp =  new Product("DeskLamp", 89.99, "UK", 1.3);
        shoppingCart.put(monitor, 2);
        shoppingCart.put(keyboard, 1);
        shoppingCart.put(deskLamp, 1);
        productsAdmin.setShoppingCart(shoppingCart);

        Assertions.assertEquals("643.45", productsAdmin.printInvoice());
    }
}
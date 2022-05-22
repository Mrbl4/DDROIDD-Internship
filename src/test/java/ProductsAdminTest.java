import org.junit.Assert;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductsAdminTest {

    @org.junit.jupiter.api.Test
    void printInvoice() {
        ProductsAdmin productsAdmin = new ProductsAdmin();
        DecimalFormat df = new DecimalFormat("##.##");
        Map<Product, Integer> shoppingCart = new HashMap<>();
        shoppingCart.put(new Product("Monitor", 164.99, "US", 1.9), 2);
        shoppingCart.put(new Product("Keyboard", 40.99, "UK", 0.7), 1);
        productsAdmin.setShoppingCart(shoppingCart);
//        productsAdmin.updateShoppingCart();
        productsAdmin.generateInvoice(); //here it sets the discounts

        Assert.assertEquals((Object) 555.36, (Object) productsAdmin.generateInvoice());

    }
}
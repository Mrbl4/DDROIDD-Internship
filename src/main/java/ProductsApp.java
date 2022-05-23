public class ProductsApp {

    public static void main(String[] args) {

        ProductsAdmin productsAdmin = new ProductsAdmin();

        productsAdmin.displayCatalogProducts();
        productsAdmin.createShoppingCart();
        productsAdmin.calculateInvoice(productsAdmin.getShoppingCart());
        productsAdmin.printInvoice();

    }
}

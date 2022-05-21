public class Main {

    public static void main(String[] args) {

        ProductsAdmin productCatalog = new ProductsAdmin();
        productCatalog.displayCatalogProducts();
        productCatalog.updateShoppingCart();
        productCatalog.viewShoppingCart();
        productCatalog.generateInvoice();
    }
}

import java.util.*;

public class ProductsAdmin {

    private List<Product> productCatalog = new ArrayList<>();
    private Map<Product, Integer> shoppingCart = new HashMap<>();
    private Invoice invoice;

    private Product mouse = new Product("Mouse", 10.99, "RO", 0.2);
    private Product keyboard = new Product("Keyboard", 40.99, "UK", 0.7);
    private Product monitor = new Product("Monitor", 164.99, "US", 1.9);
    private Product webcam = new Product("Webcam", 84.99, "RO", 0.2);
    private Product headphones = new Product("Headphones", 59.99, "US", 0.6);
    private Product deskLamp = new Product("DeskLamp", 89.99, "UK", 1.3);

    public ProductsAdmin() {
        productCatalog.add(mouse);
        productCatalog.add(keyboard);
        productCatalog.add(monitor);
        productCatalog.add(webcam);
        productCatalog.add(headphones);
        productCatalog.add(deskLamp);
        this.invoice = new Invoice();
    }


    public List<Product> getProductCatalog() {
        return productCatalog;
    }

    public void displayCatalogProducts() {
        for (Product p : productCatalog) {
            System.out.println(p.getItemName() + " - $" + p.getItemPrice());
        }
    }

    public void updateShoppingCart() {
        Scanner scanner = new Scanner(System.in);
        int mouseQuantity = 0;
        int keyboardQuantity = 0;
        int monitorQuantity = 0;
        int webcamQuantity = 0;
        int headphonesQuantity = 0;
        int deskLampQuantity = 0;
        System.out.println("Please type the name of the item you want to buy. When you finish type 'checkout'");
        String option = scanner.next();
        while (!option.equals("checkout")) {
            switch (option) {
                case "Mouse":
                    mouseQuantity++;
                    this.shoppingCart.put(mouse, mouseQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case "Keyboard":
                    keyboardQuantity++;
                    this.shoppingCart.put(keyboard, keyboardQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case "Monitor":
                    monitorQuantity++;
                    this.shoppingCart.put(monitor, monitorQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case "Webcam":
                    webcamQuantity++;
                    this.shoppingCart.put(webcam, webcamQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case "Headphones":
                    headphonesQuantity++;
                    this.shoppingCart.put(headphones, headphonesQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case "DeskLamp":
                    deskLampQuantity++;
                    this.shoppingCart.put(deskLamp, deskLampQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                default:
                    option = scanner.next();
            }
        }
    }

    public void viewShoppingCart() {
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            if (!entry.getKey().equals(null)) {
                System.out.println(entry.getKey().getItemName() + " * " + entry.getValue());
            }
        }
    }

    public void generateInvoice() {

        Double subtotal = 0.0;
        Double shippingFee = 0.0;
        Double vat = 0.0;

        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
                subtotal += entry.getValue() * entry.getKey().getItemPrice();
                shippingFee += entry.getValue() * entry.getKey().getShippingFee();
                vat += entry.getValue() * entry.getKey().getVAT();
            }

        invoice.setSubtotal(subtotal);
        invoice.setShippingFee(shippingFee);
        invoice.setTotalVat(vat);

        System.out.println(invoice);
    }
}

import java.text.DecimalFormat;
import java.util.*;

public class ProductsAdmin {

    private final List<Product> productCatalog = new ArrayList<>();
    private Map<Product, Integer> shoppingCart = new HashMap<>();
    private final Invoice invoice;

    public static final String MONITOR = "Monitor";
    public static final String MOUSE = "Mouse";
    public static final String WEBCAM = "Webcam";
    public static final String KEYBOARD = "Keyboard";
    public static final String HEADPHONES = "Headphones";
    public static final String DESKLAMP = "DeskLamp";

    public ProductsAdmin() {

        productCatalog.add(new Product(MOUSE, 10.99, "RO", 0.2));
        productCatalog.add(new Product(KEYBOARD, 40.99, "UK", 0.7));
        productCatalog.add(new Product(MONITOR, 164.99, "US", 1.9));
        productCatalog.add(new Product(WEBCAM, 84.99, "RO", 0.2));
        productCatalog.add(new Product(HEADPHONES, 59.99, "US", 0.6));
        productCatalog.add(new Product(DESKLAMP, 89.99, "UK", 1.3));
        this.invoice = new Invoice();

    }

    /**
     * Lists the Product catalog, for each item the name and the price in USD
     */
    public void displayCatalogProducts() {
        System.out.println("Product Catalog: ");
        for (Product p : productCatalog) {
            System.out.println("  " + p.getItemName() + " - $" + p.getItemPrice());
        }
    }

    /**
     * creates the shopping cart, based on the inputs entered by the customer. generated a preview of the shopping cart
     * after the user types "checkout"
     */
    public void createShoppingCart() {

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
                case MOUSE:
                    mouseQuantity++;
                    this.shoppingCart.put(getProductByName(MOUSE), mouseQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case KEYBOARD:
                    keyboardQuantity++;
                    this.shoppingCart.put(getProductByName(KEYBOARD), keyboardQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case MONITOR:
                    monitorQuantity++;
                    this.shoppingCart.put(getProductByName(MONITOR), monitorQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case WEBCAM:
                    webcamQuantity++;
                    this.shoppingCart.put(getProductByName(WEBCAM), webcamQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case HEADPHONES:
                    headphonesQuantity++;
                    this.shoppingCart.put(getProductByName(HEADPHONES), headphonesQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                case DESKLAMP:
                    deskLampQuantity++;
                    this.shoppingCart.put(getProductByName(DESKLAMP), deskLampQuantity);
                    viewShoppingCart();
                    option = scanner.next();
                    break;
                default:
                    System.out.println("Invalid product name, please enter again");
                    option = scanner.next();
            }
        }
        viewShoppingCart();
    }

    /**
     * lists the shopping cart containing items
     */
    public void viewShoppingCart() {
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            if (entry.getKey() != null) {
                System.out.println(entry.getKey().getItemName() + " * " + entry.getValue());
            }
        }
    }

    /**
     * calculates the Invoice attributes: subtotal, shipping fee, VAT, discounts, based on the Products in the shopping cart
     *
     * @return the total amount of USD that needs to be paid
     */
    public void calculateInvoice(Map<Product, Integer> shoppingCart) {

        double subtotal = 0.0;
        double shippingFee = 0.0;
        double vat = 0.0;

        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            subtotal += entry.getValue() * entry.getKey().getItemPrice();
            shippingFee += entry.getValue() * entry.getKey().getShippingFee();
            vat += entry.getValue() * entry.getKey().getVAT();
        }

        invoice.setSubtotal(subtotal);
        invoice.setShippingFee(shippingFee);
        invoice.setTotalVat(vat);
        setDiscounts();
        invoice.setTotal();

    }

    /**
     * checks for the special offers eligibility and calculates the Invoice's discounts, based on the conditions bellow:
     * 10% off Keyboards, 50% discount on Desk Lamp if you buy 2 Monitors, $10 shipping fee discount if you buy 2 or more products
     */
    private void setDiscounts() {

        Double totalDiscounts = 0.0;

        for (Product p : shoppingCart.keySet()) {

            if (p.getItemName().equals(MONITOR)) {
                int n = shoppingCart.get(p);
                if ((n >= 2) && hasLamp()) {
                    invoice.setDeskLampDiscount(getProductByName(DESKLAMP).getItemPrice() * 0.5);
                    totalDiscounts += invoice.getDeskLampDiscount();
                }
            }

            if (p.getItemName().equals(KEYBOARD)) {
                int n = shoppingCart.get(p);
                invoice.setKeyboardDiscount(n * p.getItemPrice() * 0.1);
                totalDiscounts += invoice.getKeyboardDiscount();
            }

        }

        if (shoppingCart.values().size() >= 2) {
            invoice.setShippingFeeDiscount(10.0);
            totalDiscounts += invoice.getShippingFeeDiscount();
        }

        invoice.setTotalDiscounts(totalDiscounts);
    }

    /**
     * Displays the detailed Invoice, containing Subtotal, Shipping Fee, total VAT and detailed Discounts values
     * @return the total of the Invoice
     */
    String printInvoice() {

        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println("Invoice: \n" + "Subtotal: $" + df.format(invoice.getSubtotal()) + "\n" +
                "Shipping: $" + df.format(invoice.getShippingFee()) + "\n" +
                "VAT: $" + df.format(invoice.getTotalVat()));
        if (invoice.getKeyboardDiscount() != null) {
            System.out.println("Discounts: \n" + "10% off keyboards: -$" + df.format(invoice.getKeyboardDiscount()));
        }
        if (invoice.getShippingFeeDiscount() != null) {
            System.out.println("$10 off shipping: -$" + df.format(invoice.getShippingFeeDiscount()));
        }
        if (invoice.getDeskLampDiscount() != null) {
            System.out.println("50% discount on DeskLamp: -$" + df.format(invoice.getDeskLampDiscount()));
        }
        System.out.println("TOTAL: $" + df.format(invoice.getTotal()));

        return df.format((invoice.getTotal()));
    }

    /**
     * checks if the shopping cart contains DeskLamp, in order to apply the special offer of 50% off if you buy 2 Monitors
     * @return
     */
    private boolean hasLamp() {
        for (Product p : shoppingCart.keySet()) {
            if (p.getItemName().equals(DESKLAMP)) {
                return true;
            }
        }
        return false;
    }

    public void setShoppingCart(Map<Product, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    private Product getProductByName(String name) {
        for (Product p : productCatalog) {
            if (p.getItemName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}




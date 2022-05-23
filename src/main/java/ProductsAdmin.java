import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.*;

public class ProductsAdmin {

    private final List<Product> productCatalog = new ArrayList<>();
    private Map<Product, Integer> shoppingCart = new HashMap<>();
    private Invoice invoice;

    private final Product mouse = new Product("Mouse", 10.99, "RO", 0.2);
    private final Product keyboard = new Product("Keyboard", 40.99, "UK", 0.7);
    private final Product monitor = new Product("Monitor", 164.99, "US", 1.9);
    private final Product webcam = new Product("Webcam", 84.99, "RO", 0.2);
    private final Product headphones = new Product("Headphones", 59.99, "US", 0.6);
    private final Product deskLamp = new Product("DeskLamp", 89.99, "UK", 1.3);

    public ProductsAdmin() {

        productCatalog.add(mouse);
        productCatalog.add(keyboard);
        productCatalog.add(monitor);
        productCatalog.add(webcam);
        productCatalog.add(headphones);
        productCatalog.add(deskLamp);
//        productCatalog.add(new Product("Mouse", 10.99, "RO", 0.2));
//        productCatalog.add(new Product("Keyboard", 40.99, "UK", 0.7));
//        productCatalog.add(new Product("Monitor", 164.99, "US", 1.9));
//        productCatalog.add(new Product("Webcam", 84.99, "RO", 0.2));
//        productCatalog.add(new Product("Headphones", 59.99, "US", 0.6));
//        productCatalog.add(new Product("DeskLamp", 89.99, "UK", 1.3));
        this.invoice = new Invoice();

    }

    /**
     * Lists the Product catalog, for each item the name and the price in USD
     */
    public void displayCatalogProducts() {
        System.out.println("Product Catalog: ");
        for (Product p : productCatalog) {
            System.out.println(p.getItemName() + " - $" + p.getItemPrice());
        }
        System.out.println("Please ");
    }


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
        viewShoppingCart();
    }

    public void viewShoppingCart() {
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            if (!entry.getKey().equals(null)) {
                System.out.println(entry.getKey().getItemName() + " * " + entry.getValue());
            }
        }
    }

    /**
     * calculates the Invoice attributes: subtotal, shipping fee, VAT, discounts, based on the Products in the shopping cart
     *
     * @return the total amount of USD that needs to be paid
     */
    private void calculateInvoice(Map<Product, Integer> shoppingCart) {

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
        setDiscounts();
        invoice.setTotal();

    }

    /**
     * checks for the special offers conditions and calculates the Invoice's discounts based on each condition:
     * 10% off Keyboards, 50% discount on Desk Lamp if you buy 2 Monitors, $10 shipping fee discount if you buy 2 or more products
     *
     * @return the total sum of discounts
     */
    private void setDiscounts() {

        Double totalDiscounts = 0.0;
        boolean hasLamp = false;
        Double deskLampPrice = 0.0;

//        if (shoppingCart.containsKey(monitor) && shoppingCart.containsKey(deskLamp)) {

        Set<Product> products = shoppingCart.keySet();

        //check if the cart has DeskLamp
        for (Product p: products){
            if (p.getItemName().equals("DeskLamp")){
                hasLamp = true;
                deskLampPrice = p.getItemPrice();
            }
        }

        for (Product p : products) {

            if (p.getItemName().equals("Monitor")) {
                int n = shoppingCart.get(p);
                if ((n >= 2) && hasLamp) {
                    invoice.setDeskLampDiscount(deskLampPrice * 0.5);
                    totalDiscounts += invoice.getDeskLampDiscount();
                }
            }

            if (p.getItemName().equals("Keyboard")) {
                int n = shoppingCart.get(p);
                invoice.setKeyboardDiscount(n * p.getItemPrice() * 0.1);
                totalDiscounts += invoice.getKeyboardDiscount();
            }

        }

            int noOfProducts = 0;
            List<Integer> productsQuantity = new ArrayList<>(shoppingCart.values());
            for (Integer i : productsQuantity) {
                noOfProducts += i;
            }

            if (noOfProducts >= 2) {
                invoice.setShippingFeeDiscount(10.0);
                totalDiscounts += invoice.getShippingFeeDiscount();
            }

            invoice.setTotalDiscounts(totalDiscounts);
        }


        String printInvoice() {

            calculateInvoice(shoppingCart);

            DecimalFormat df = new DecimalFormat("##.##");

            System.out.println("Invoice: \n" + "Subtotal: $" + df.format(invoice.getSubtotal()) + "\n" +
                    "Shipping: $" + df.format(invoice.getShippingFee()) + "\n" +
                    "VAT: $" + df.format(invoice.getTotalVat()));
            if (!(invoice.getKeyboardDiscount() == null)) {
                System.out.println("Discounts: \n" + "10% off keyboards: -$" + df.format(invoice.getKeyboardDiscount()));
            }
            if (!(invoice.getShippingFeeDiscount() == null)) {
                System.out.println("$10 off shipping: -$" + df.format(invoice.getShippingFeeDiscount()));
            }
            if (!(invoice.getDeskLampDiscount() == null)) {
                System.out.println("50% discount on DeskLamp: -$" + df.format(invoice.getDeskLampDiscount()));
            }
            System.out.println("TOTAL: $" + df.format(invoice.getTotal()));

            return df.format((invoice.getTotal()));
        }

        public void setShoppingCart (Map < Product, Integer > shoppingCart){
            this.shoppingCart = shoppingCart;
        }
    }


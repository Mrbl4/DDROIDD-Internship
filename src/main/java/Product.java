public class Product {

    private String itemName;
    private Double itemPrice;
    private String shippedFrom;
    private Double weight;
    private Double shippingFee;
    private Double VAT;


    public Product(String itemName, Double itemPrice, String shippedFrom, Double weight) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.shippedFrom = shippedFrom;
        this.weight = weight;
        setShippingFee();
        this.VAT = itemPrice * 0.19;
    }

    private void setShippingFee() {
        if (shippedFrom.equals("RO")){
            this.shippingFee = (double) Math.round(weight * 1 / 0.1);
        }
        if (shippedFrom.equals("UK")){
            this.shippingFee = (double) Math.round(weight * 2 / 0.1);
        }
        if (shippedFrom.equals("US")){
            this.shippingFee = (double) Math.round(weight * 3 / 0.1);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", shippedFrom='" + shippedFrom + '\'' +
                ", weight=" + weight +
                ", shippingFee=" + shippingFee +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public Double getVAT() {
        return VAT;
    }


}

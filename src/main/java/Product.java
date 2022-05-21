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

    public void setShippingFee() {
        if (shippedFrom.equals("RO")){
            this.shippingFee = Double.valueOf(Math.round(weight * 1/0.1));
        }
        if (shippedFrom.equals("UK")){
            this.shippingFee = Double.valueOf(Math.round(weight * 2/0.1));
        }
        if (shippedFrom.equals("US")){
            this.shippingFee = Double.valueOf(Math.round(weight * 3/0.1));
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

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getShippedFrom() {
        return shippedFrom;
    }

    public void setShippedFrom(String shippedFrom) {
        this.shippedFrom = shippedFrom;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }
}

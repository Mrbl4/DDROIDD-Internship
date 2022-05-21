public class Invoice {

    private Double subtotal;
    private Double shippingFee;
    private Double totalVat;
//    private Double discount;

//    public Invoice(Double subtotal, Double shippingFee, Double totalVat, Double discount) {
//        this.subtotal = subtotal;
//        this.shippingFee = shippingFee;
//        this.totalVat = totalVat;
//        this.discount = discount;
//    }

    public Invoice() {
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public void setTotalVat(Double totalVat) {
        this.totalVat = totalVat;
    }

//    public void setDiscount(Double discount) {
//        this.discount = discount;
//    }

    @Override
    public String toString() {
        return "Invoice: \n" + "Subtotal: $" + subtotal + "\n" +
                "Shipping: $" + shippingFee + "\n" +
                "VAT: $" + totalVat + "\n" +
//                "Discounts: $" + discount +
                "TOTAL: $" + (shippingFee+subtotal+totalVat);
    }
}

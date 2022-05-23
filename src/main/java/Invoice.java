public class Invoice {

    private Double subtotal;
    private Double shippingFee;
    private Double totalVat;
    private Double keyboardDiscount;
    private Double deskLampDiscount;
    private Double shippingFeeDiscount;
    private Double totalDiscounts;
    private Double total;

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

    public Double getKeyboardDiscount() {
        return keyboardDiscount;
    }

    public void setKeyboardDiscount(Double keyboardDiscount) {
        this.keyboardDiscount = keyboardDiscount;
    }

    public Double getDeskLampDiscount() {
        return deskLampDiscount;
    }

    public void setDeskLampDiscount(Double deskLampDiscount) {
        this.deskLampDiscount = deskLampDiscount;
    }

    public void setShippingFeeDiscount(Double shippingFeeDiscount) {
        this.shippingFeeDiscount = shippingFeeDiscount;
    }

    public void setTotalDiscounts(Double totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public Double getTotalVat() {
        return totalVat;
    }

    public Double getShippingFeeDiscount() {
        return shippingFeeDiscount;
    }

    public void setTotal() {
        this.total = this.subtotal+this.totalVat+this.shippingFee-this.totalDiscounts;
    }

    public double getTotal() {
        return total;
    }
}


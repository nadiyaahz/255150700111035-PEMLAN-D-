class Invoice implements Payable {
    private String productName;
    private Integer quantity;
    private Integer pricePerItem;

    public Invoice(String productName, Integer quantity, Integer pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return (double) quantity * pricePerItem;
    }

    public void printInvoiceDetail() {
        System.out.printf("- %-17s | %d x Rp %-8d = Rp%.0f\n", 
            productName, quantity, pricePerItem, getPayableAmount());
    }
}
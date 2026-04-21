class Employee2 implements Payable {
    private Integer registrationNumber;
    private String name;
    private Integer salaryPerMonth;
    private Invoice[] invoices;

    public Employee2(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalBelanja = 0;
        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }
        return salaryPerMonth - totalBelanja;
    }

    public void displayInfo() {
        System.out.println("====================================================");
        System.out.println("Nama            : " + name);
        System.out.println("No. Registrasi  : " + registrationNumber);
        System.out.println("Gaji Bulanan    : Rp" + salaryPerMonth);
        System.out.println("----------------------------------------------------");
        System.out.println("Detail belanja koperasi:");
        
        double totalHutang = 0;
        for (Invoice inv : invoices) {
            inv.printInvoiceDetail();
            totalHutang += inv.getPayableAmount();
        }
        
        System.out.println("----------------------------------------------------");
        System.out.println("Total Hutang Belanja : Rp " + (int)totalHutang);
        System.out.println("Gaji Bersih          : Rp " + (int)getPayableAmount());
        System.out.println("====================================================\n");
    }
}
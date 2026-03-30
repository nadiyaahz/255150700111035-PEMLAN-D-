public class Vehicle1 { 
    private double load; 
    private static final double maxLoad; // Hilangkan inisialisasi langsung di sini agar bisa diatur via konstruktor

    // constructor default
    public Vehicle1() {
        this.maxLoad = 10000;
    }

    // constructor parameter
    public Vehicle1(double max) { 
        this.maxLoad = max; 
    } 

    public double getLoad() { 
        return this.load; 
    } 

    public double getMaxLoad() { 
        return this.maxLoad; 
    } 

    public boolean addBox(double weight) { 
        if (weight <= 0) return false;

        double temp = this.load + weight; 
        if (temp <= maxLoad) { 
            this.load = temp; 
            return true; 
        } else { 
            return false; 
        } 
    } 
}
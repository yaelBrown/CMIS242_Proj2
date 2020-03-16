public class Automobile {
    protected String make;
    protected String model;
    protected Double price;

    public Automobile(String make, String model, Double price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public double salesTax() {
        return this.price * .05;
    }

    public String toString() {
        double tax = this.salesTax();
        double total = this.price + tax;
        return this.make + " " + this.model + " that costs $" + total + ". That includes $" + tax + " sales tax.";
    }
}
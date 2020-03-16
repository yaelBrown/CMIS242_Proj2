public class Hybrid extends Automobile {
    private int mpg;

    public Hybrid(String make, String model, Double price, int mpg) {
        super(make, model, price);
        this.mpg = mpg;
    }

    public double salesTax() {
        if (this.mpg < 40) {
            return (this.price * .05) - 100;
        } else {
            return (this.price * .05) - ((this.mpg - 40) * 2);
        }
    }

    public String toString() {
        double tax = this.salesTax();
        double total = this.price + tax;
        return this.make + " " + this.model + " that costs $" + total + ". That includes $" + tax + " sales tax. Also, gets " + this.mpg + " miles per gallon.";
    }

}
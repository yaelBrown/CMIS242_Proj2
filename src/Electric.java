public class Electric extends Automobile {
    private int weight;

    public Electric(String make, String model, Double price, int weight) {
        super(make, model, price);
        this.weight = weight;
    }

    public double salesTax() {
        if (this.weight < 3000) {
            return (this.price * 05) - 200;
        } else {
            return (this.price * .05) - 150;
        }
    }

    public String toString() {
        double tax = this.salesTax();
        double total = this.price + tax;
        return this.make + " " + this.model + " that costs $" + total + ". That includes $" + tax + " sales tax. Also, weighs " + this.weight + " lbs.";
    }

}
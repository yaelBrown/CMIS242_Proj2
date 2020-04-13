/*
Filename: Hybrid.java
Author: Yael Brown
Date: 4/12/2020
Brief Purpose of the Program: To calculate sales tax for different types of automobiles.
*/

public class Hybrid extends Automobile {
    private int mpg;

    public Hybrid(String mM, Double price, int mpg) {
        super(mM, price);
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
        return "This " + this.makeModel +  " that costs $" + total + ". That includes $" + tax + " sales tax. Also, gets " + this.mpg + " miles per gallon.";
    }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("Hybrid Vehicle");
        System.out.println("MPG: " + mpg);
    }
}
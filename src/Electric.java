/*
Filename: Electric.java
Author: Yael Brown
Date: 4/12/2020
Brief Purpose of the Program: To calculate sales tax for different types of automobiles.
*/

public class Electric extends Automobile {
    private int weight;

    public Electric(String mM, Double price, int weight) {
        super(mM, price);
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
        return "This " + this.makeModel + " that costs $" + total + ". That includes $" + tax + " sales tax. Also, weighs " + this.weight + " lbs.";
    }

    @Override
    public void displayReport() {
        super.displayReport();
        System.out.println("Electric Vehicle");
        System.out.println("Weight: " + weight);
    }
}
/*
Filename: Automobile.java
Author: Yael Brown
Date: 4/12/2020
Brief Purpose of the Program: To calculate sales tax for different types of automobiles.
*/

public class Automobile {
    protected String makeModel;
    protected Double price;

    public Automobile(String makeModel, Double price) {
        this.makeModel = makeModel;
        this.price = price;
    }

    public double salesTax() {
        return this.price * .05;
    }

    public String toString() {
        double tax = this.salesTax();
        double total = this.price + tax;
        return "This " + this.makeModel + " that costs $" + total + ". That includes $" + tax + " sales tax.";
    }

    public void displayReport() {
        double tax = this.salesTax();
        double total = this.price + tax;
        System.out.println("Make and Model: " + this.makeModel);
        System.out.println("Sales Price: " + this.price);
        System.out.println("Sales Tax: " + total);
    }

}
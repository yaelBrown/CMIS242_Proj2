/*
Filename: Project2.java
Author: Yael Brown
Date: 4/12/2020
Brief Purpose of the Program: To calculate sales tax for different types of automobiles.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Project2 extends GUI {
    static ArrayList<Automobile> autos = new ArrayList<>();

    Project2() {
        super();
    }

    public void saveAuto(Automobile a) {
        // take values that are in the gui and save them to arraylist autos
        autos.add(a);
    }

    public static void displayReport() {
        // Displays report of last 5 autos
        for (Automobile a : autos) {
            a.displayReport();
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Project2 p2 = new Project2();
        p2.display();
    }
}
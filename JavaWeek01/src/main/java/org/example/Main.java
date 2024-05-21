package org.example;

import static java.lang.StringTemplate.STR;

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}

import static java.lang.StringTemplate.STR;

public class Main {
// exercise
    //Write a program to create and print out the values of variables to hold the following data. The point here is to think about the types of variables needed to hold particular types of data.
    //a.A vehicle identification number in the range 0 to 1000000
    //b.A vehicle make /model (i.e. Ford Explorer)
    //c.a vehicle color
    //d.whether the vehicle has a towing package
    //e.an odometer reading
    //f.a price
    //g.a quality rating (A, B, or C)

    // Exercise a
    public static String setIdentificationNumber(int identificationNumber) {
        String message = "";
        if (identificationNumber >= 0 && identificationNumber <= 1000000) {
            message = STR."Identification number set to \{identificationNumber}";
        } else {
            message = STR."Invalid identification number \{identificationNumber}";
        }
        System.out.println(message);
        return message;
    }

// Exercise d

    public static String hasTowingPackaging(boolean hasTowingPackage) {
        String message = "";
        if (hasTowingPackage) {
            message = STR."This vehicle has a towing package";
        } else {
            message = STR."This vehicle doesn't have a towing package";
        }
        System.out.println(message);
        return message;
    }

    // exercise b
    public static void vehicleModel(String[] args) {
        String vehicleModel = "Ford";
        System.out.println(STR."The vehicle model is $ \{vehicleModel}");
    }

    // exercise c
    public static void color(String[] args) {
        String color = "yellow";
        System.out.println(STR."The vehicle color is $ \{color}");
    }

    // exercise E
    public static void odometer(String[] args) {
        int odometer = 15000;
        System.out.println(STR."\{odometer} miles");
    }

    // exercise F
    public static void price() {
        double price = 15000.0;
        System.out.println(STR."The vehicle price is $ \{price}");
    }

    // exercise G
    public static void qualityRange() {
        char qualityRange = 'a';
        System.out.println(STR."The vehicle's rating is: \{qualityRange}");
    }


// EXERCISE #2 - LOOP

//Write a program that goes in a loop from -500 to +500 and prints out all numbers that are divisible by either 3 or 7. Do this with a for loop and a while loop.

    public static void testLoop () {
        for (int i = -500; i <= 500; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void forLoop() {
        int count = 0;
        for (int value = -500; value <= 500; value++) {
            if (value % 3 == 0 || value % 7 == 0) {
                count++;
            }
        }
        System.out.println(STR."The result is \{count}");

    }

// EXERCISE #3 - WHILE LOOP
// Change your program to print out a count of the numbers between -500 to +500 that are divisible by either 3 or 7.

    public static void WhileLoop() {
        int i = -500;
        while (i <= 500) {
            if (i % 3 == 0 || i % 7 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }

// EXERCISE #4 - test
// Once you have the count, rewrite your program as a JUnit test and assert that it returns the correct count.

    public static int testWhile () {
        int count = 0;
        int i = -500;
        while (i <= 500) {
            if (i % 3 == 0 || i % 7 == 0) {
                System.out.println(i);
                count++;
            }
            i++;
        };
        System.out.println(STR."Total of divisible numbers by 3 or 7 equals \{count}");
        return count;
    }


}

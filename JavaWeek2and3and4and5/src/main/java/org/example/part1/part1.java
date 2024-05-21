package org.example.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class part1 {
    public static void main(String[] args) {
        //Task 2.a.3
        int[] array1 = createArray(3,5);
        System.out.println("----------------------- Array 1");
        System.out.println(Arrays.toString(array1));

        System.out.println("----------------------- Array 2");
        int[] array2 = createArray(10,20);
        System.out.println(Arrays.toString(array2));
    }

    public static int[] createArraySquared() {
        //Task 1.a e b
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++){
            array[i] = i*i;
            System.out.println(i + " - " + array[i]);
        }
        return array;
    }

    //Task 2.a1 e 2.a.b
    public static int[] createArray(int size, int limit){
        int[] array = new int[size];
//        System.out.println(array.length);
        for(int i = 0; i < array.length; i++){
            int randomInt = ThreadLocalRandom.current().nextInt(limit);
            array[i] = randomInt;

        }
        return array;
    }


    //Task 3 - Instead of the Array of students, use a List of students.

    public static void Students() {
        List<String> students = new ArrayList<>();
        students.add("Andre Uys");
        students.add("Alan Morales Rueda");
        students.add("Audomaro Gonzalez");
        students.add("Caio Henrique");
        students.add("Chris Valenci");
        students.add("Daniel Lee");
        students.add("Humberto Rojas");
        students.add("Javier Mendoza");
        students.add("Joao Alonso");
        students.add("Luis Barraza Hernandez");
        students.add("Mariana Duarte");
        students.add("Miguel Angel Rodriguez");
        students.add("Rosendo Galindo");
        students.add("Sean Jaw");
        students.add("Tiffany Yee");
        students.add("Vincent Vu");
        students.add("Nathaniel Schieber");
        students.add("Dylan McClain");
        students.add("Grant Stampfli");

    }

}

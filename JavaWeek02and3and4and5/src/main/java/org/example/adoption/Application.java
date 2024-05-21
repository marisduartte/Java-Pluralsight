package org.example.adoption;

import org.example.adoption.domain.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        Adopter adopter1 = new Adopter(
//                1,
//                "Caio",
//                "Amora",
//                434434343L,
//                LocalDate.of(2024, Month.APRIL, 1),
//                "Golden",
//                Adopter.AnimalType.DOG
//        );
//
//        Adopter adopter2 = new Adopter(
//                1,
//                "Joao",
//                "Julie",
//                13988299943L,
//                "Siamese",
//                Adopter.AnimalType.CAT
//        );
//
//        Adopter adopter3 = new Adopter(
//                1,
//                "Mariana",
//                "Julie",
//                11970914478L,
//                LocalDate.of(2024, Month.MARCH, 10),
//                Adopter.AnimalType.DOG
//        );
//
//
//        System.out.println(adopter1);
//        System.out.println("---------------------------------------------------");
//        System.out.println(adopter2);
//        System.out.println("---------------------------------------------------");
//        System.out.println(adopter3);
//    }
        // 2. Change your application class to use the Constructors to create a List of 2 Adopters and print them out using a toString method.
            List<Adopter> adopters = new ArrayList<>();
            adopters.add(new Adopter(4, "Mariana", "Maui", 1243443343, LocalDate.of(2024, Month.APRIL, 1), "Yorkshire", Adopter.AnimalType.DOG));
            adopters.add(new Adopter(5, "Frank", "Kauai", 1223445678, LocalDate.now(), "Bulldog", Adopter.AnimalType.DOG));

        System.out.println(adopters);
    }


}


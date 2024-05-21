package org.example.adoption.domain;
import java.time.LocalDate;

import static java.lang.StringTemplate.STR;

public class Adopter {
    private int id;
    private String adopterName;
    private String petName;
    private long phoneNumber;
    private LocalDate dateOfAdoption;
    private String animalBreed;
    private AnimalType animalType;

    // 1. Constructors
    //a.Create appropriate Constructors for the class(es) you have created for the Adoption application.
    // Try and initialize your objects in only one place in the code.
    //b.Make sure your objects are always properly initialized, no matter which constructor is called.
    // All variables that should not be null should have an appropriate value.

    // First Constructor
    public Adopter(int id, String adopterName, String petName, long phoneNumber, LocalDate dateOfAdoption, String animalBreed, AnimalType animalType) {
        this(id, adopterName, petName, phoneNumber, animalBreed, animalType);
        this.dateOfAdoption = dateOfAdoption;
    }

    // second constructor
    public Adopter(int id, String adopterName, String petName, long phoneNumber, String animalBreed, AnimalType animalType) {
        this(id, adopterName, petName, phoneNumber, animalType);
        this.dateOfAdoption = LocalDate.now();
        this.animalBreed = animalBreed;
    }

    // third constructor
    public Adopter(int id, String adopterName, String petName, long phoneNumber, LocalDate dateOfAdoption, AnimalType animalType) {
        this(id, adopterName, petName, phoneNumber, animalType);
        this.dateOfAdoption = dateOfAdoption;
        this.animalBreed = "unknown";
    }

    private Adopter(int id, String adopterName, String petName, long phoneNumber, AnimalType animalType) {
        this.id = id;
        this.adopterName = adopterName;
        this.petName = petName;
        this.phoneNumber = phoneNumber;
        this.animalType = animalType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfAdoption() {
        return dateOfAdoption;
    }

    public void setDateOfAdoption(LocalDate dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }

    public String getAnimalBreed() {
        return animalBreed;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public enum AnimalType {
        CAT,
        DOG,
        TURTLE
    }

    // 2. Change your application class to use the Constructors to create a List of 2 Adopters
    // and print them out using a toString method.

    @Override
    public String toString() {
        return STR."ID: \{this.id} \nAdopterName: \{this.adopterName} \nPetName: \{this.petName} \nphoneNumber: \{this.phoneNumber} \ndateOfAdoption \{this.dateOfAdoption} \nAnimalBreed: \{this.animalBreed} \nAnimalType: \{this.animalType}";
    }
}


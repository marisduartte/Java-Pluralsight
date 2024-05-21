package adoption;

import org.example.adoption.domain.Adopter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class AdopterTest {

    // Write Unit tests for all your constructors. Aim for 100% coverage on the constructors.

    @Test
    public void testFirstConstructor(){

        int id = 1;
        String adopterName = "Caio";
        String petName = "Amora";
        long phoneNumber = 434434343L;
        LocalDate dateOfAdoption = LocalDate.of(2024, Month.APRIL, 1);
        String animalBreed = "Golden";
        Adopter.AnimalType animalType =  Adopter.AnimalType.DOG;

        Adopter adopter1 = new Adopter(
            id, adopterName,petName, phoneNumber, dateOfAdoption, animalBreed, animalType);
            Assertions.assertEquals(id, adopter1.getId());
            Assertions.assertEquals(adopterName, adopter1.getAdopterName());
            Assertions.assertEquals(petName, adopter1.getPetName());
            Assertions.assertEquals(phoneNumber, adopter1.getPhoneNumber());
            Assertions.assertEquals(dateOfAdoption, adopter1.getDateOfAdoption());
            Assertions.assertEquals(animalBreed, adopter1.getAnimalBreed());
            Assertions.assertEquals(animalType, adopter1.getAnimalType());
    }


    @Test
    public void testSecondConstructor(){

        int id = 1;
        String adopterName = "Joao";
        String petName = "Julie";
        long phoneNumber = 13988299943L;
        String animalBreed = "Siamese";
        Adopter.AnimalType animalType =  Adopter.AnimalType.CAT;

        Adopter adopter1 = new Adopter(
                id, adopterName,petName, phoneNumber, animalBreed, animalType);
        Assertions.assertEquals(id, adopter1.getId());
        Assertions.assertEquals(adopterName, adopter1.getAdopterName());
        Assertions.assertEquals(petName, adopter1.getPetName());
        Assertions.assertEquals(LocalDate.now(), adopter1.getDateOfAdoption());
        Assertions.assertEquals(phoneNumber, adopter1.getPhoneNumber());
        Assertions.assertEquals(animalBreed, adopter1.getAnimalBreed());
        Assertions.assertEquals(animalType, adopter1.getAnimalType());
    }

    @Test
    public void testThirdConstructor(){

        int id = 1;
        String adopterName = "Mariana";
        String petName = "Julie";
        long phoneNumber = 11970914478L;
        Adopter.AnimalType animalType =  Adopter.AnimalType.DOG;

        Adopter adopter1 = new Adopter(
                id, adopterName,petName, phoneNumber, LocalDate.now(), animalType);
        Assertions.assertEquals(id, adopter1.getId());
        Assertions.assertEquals(adopterName, adopter1.getAdopterName());
        Assertions.assertEquals(petName, adopter1.getPetName());
        Assertions.assertEquals(phoneNumber, adopter1.getPhoneNumber());
        Assertions.assertEquals("unknown", adopter1.getAnimalBreed());
        Assertions.assertEquals(animalType, adopter1.getAnimalType());
    }

}

package adoption.service;

import org.example.adoption.service.AdopterService;
import org.example.adoption.domain.Adopter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdopterServiceTest {
    @Test
    public void testAdopterInsert(){
        AdopterService adopterService = new AdopterService();
        Adopter adopter = new Adopter(11, "Lucas", "Marley", 13988164476l, LocalDate.now(), Adopter.AnimalType.DOG);
        Adopter insertedAdopter = adopterService.addAdopter(adopter);
        System.out.println("adopter: " + insertedAdopter.toString());
        assertEquals(11, insertedAdopter.getId());
    }
}

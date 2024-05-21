import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testIdentificationNumberSuccess(){
        String message = Main.setIdentificationNumber(1);
        assertEquals("Identification number set to 1", message);
    }

    // Exercise a
    @Test
    public void testIdentificationNumberFail(){
        String message = Main.setIdentificationNumber(-1);
        assertEquals("Invalid identification number -1", message);
    }

    // Exercise f



    // Exercise d
    @Test
    public void testHasTowingPackagesSuccess(){
        String message = Main.hasTowingPackaging(true);
        assertEquals("This vehicle has a towing package", message);
    }

    @Test
    public void testHasTowingPackagesFail(){
        String message = Main.hasTowingPackaging(false);
        assertEquals("This vehicle doesn't have a towing package", message);
    }

    @Test
    public void testWhile(){
        int count = Main.testWhile();
        assertEquals(429, count);
    }

}


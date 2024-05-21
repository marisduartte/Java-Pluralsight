package part1;

import org.example.part1.part1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class part1Test {
    //Task 2.a.c
    @Test
    public void testArrayValue(){
        int[] array = part1.createArraySquared();
        assertEquals(36, array[6]);
    }
}



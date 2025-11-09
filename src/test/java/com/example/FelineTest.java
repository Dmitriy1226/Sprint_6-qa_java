package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyReturnsCatsFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensDefaultIsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithCustomCount() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }
}

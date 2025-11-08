package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnInvalidSex() throws Exception {
        new Lion(feline, "Неизвестно");
    }

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(feline, "Самец");
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodUsesFelineEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion(feline, "Самка");
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(feline).eatMeat();
    }
}
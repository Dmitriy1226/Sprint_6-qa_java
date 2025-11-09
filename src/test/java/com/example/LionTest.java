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
    public void getKittensReturnsValueFromFeline() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(feline, "Самец");
        int actualKittens = lion.getKittens();

        assertEquals(3, actualKittens);
    }

    @Test
    public void getKittensCallsFelineGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();

        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion(feline, "Самка");
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFoodCallsFelineEatMeat() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        lion.getFood();

        Mockito.verify(feline).eatMeat();
    }
}
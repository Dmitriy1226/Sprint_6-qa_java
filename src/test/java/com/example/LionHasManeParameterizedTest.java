package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionHasManeParameterizedTest {

    @Parameterized.Parameters(name = "Пол: {0}, грива: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    private final String sex;
    private final boolean expectedHasMane;

    public LionHasManeParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Test
    public void doesHaveManeDependsOnSex() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(felineMock, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
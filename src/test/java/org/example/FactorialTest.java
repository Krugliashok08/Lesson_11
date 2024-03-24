package org.example;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
@Test
public void testFactorial() {
    assertEquals(1, Factorial.Factorial(0));
    assertEquals(1, Factorial.Factorial(1));
    assertEquals(120, Factorial.Factorial(5));
}

    @Test
    void testFactorialCondition() {
        assertEquals(120, Factorial.FactorialCondition(5, true));
        assertEquals(24, Factorial.FactorialCondition(5, false));
    }

}
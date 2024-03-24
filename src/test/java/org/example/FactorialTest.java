package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
@Test
    public void testFactorial() {
    assertEquals(1, Factorial.Factorial(0));
    assertEquals(1, Factorial.Factorial(1));
    assertEquals(2, Factorial.Factorial(2));
}
}


import les5.Calculator;
import les5.CalculatorI;
import les5.les5_1;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
//Описание всех функций
//https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class les5_1_Test {

    Calculator calc = null;

    CalculatorI iCalculator = mock(CalculatorI.class);

    @BeforeAll
    public void setUp() {
        calc = new Calculator(iCalculator);
    }

    @Test
    public void testMult() {
        when(iCalculator.add(2, 3)).thenReturn(5);
        assertEquals(10, calc.mult(2, 3));
        verify(iCalculator).add(2, 3);
    }

}

import les4.les4_1;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//Описание всех функций
//https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

public class les4_1_Test {

    @Test
    public void testSetArray() {
        les4_1 m = new les4_1();
        int[] arr = m.setArray(4, 6, 8, 10, 0);
        int[] expected = {4, 6, 8, 10, 0};
        assertArrayEquals(arr, expected);
    }


    @Nested
    @DisplayName("Производим простую математику")
    class SimpleMath {

        les4_1 m = null;

        @BeforeEach
        public void setUp() {
            m = new les4_1();
        }

        @Test
        public void testDivide() {
            assertEquals(5, m.divide(10, 2), "Деление не работает");
            assertThrows(ArithmeticException.class, () -> m.divide(5, 0), "Исключение обрабатывается не корректно");
        }

        @Test
        @DisplayName("Функция для суммирования")
        public void summTest() {
            assertAll( //Объеденяет несколько проверок
                    () -> assertEquals(12, m.summ(5, 7), "Сложение не работает"),
                    () -> assertNotEquals(12, 10)
            );
        }
    }
}

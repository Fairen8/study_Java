import les3.les3_1;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//Описание всех функций
//https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

public class les3_1_Test {

    @Test
    @RepeatedTest(3) //RepeatedTest позволяет выполнить тест несколько раз
    public void testSetArray() {
        les3_1 m = new les3_1();
        int[] arr = m.setArray(4, 6, 8, 10, 0);
        int[] expected = {4, 6, 8, 10, 0};
        assertArrayEquals(arr, expected);
    }


    @Nested //Nested позволяет создать класс наследник
    @DisplayName("Производим простую математику")
    class SimpleMath {

        les3_1 m = null;

        @BeforeEach //Позволяет запускать функцию перед каждой функцией
        /*
        Также существуют анотации:
        BeforeAll, она срабатывает перед запуском класса
        AfterEach, она срабатывает после каждого метода
        AfterAll, она срабатывает после всего класса
        */
        public void setUp() {
            m = new les3_1();
        }

        @Test
        @Tag("Деление")
        public void testDivide() {
            assertEquals(5, m.divide(10, 2), "Деление не работает");
            assertThrows(ArithmeticException.class, () -> m.divide(5, 0), "Исключение обрабатывается не корректно");
        }

        @Test
        @Disabled  //Функция игнорируется
        @DisplayName("Функция для суммирования") //Псевдоним для функции
        public void summTest() {
            assertAll( //Объеденяет несколько проверок
                    () -> assertEquals(12, m.summ(5, 7), "Сложение не работает"),
                    () -> assertNotEquals(12, 10)
            );


        }
    }
}

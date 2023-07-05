import les2.les2_1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//Описание всех функций
//https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

public class les2_1_Test {

    @Test
    public void summTest() {
        les2_1 m = new les2_1();
        assertEquals(12, m.summ(5, 7), "Сложение не работает");    //Метод для сравнения чисел

    }

    @Test
    public void testSetArray() {
        les2_1 m = new les2_1();
        int[] arr = m.setArray(4, 6, 8, 10, 0);
        int[] expected = {4, 6, 8, 10, 0};
        assertArrayEquals(arr, expected); //Метод для сравнения массивов
    }

    @Test
    public void testDivide() {
        les2_1 m = new les2_1();
        assertEquals(5, m.divide(10, 2), "Деление не работает");
        assertThrows(ArithmeticException.class, () -> m.divide(5, 0), "Исключение обрабатывается не корректно"); //Функция для обработки исключений
    }

}

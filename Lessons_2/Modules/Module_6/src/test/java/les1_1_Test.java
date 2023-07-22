import les1.les1_1;
import org.junit.jupiter.api.Test;
//Описание всех функций
//https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

public class les1_1_Test {
    @Test
    void summTest() {
        les1_1 m = new les1_1();
        int res = m.summ(5, 7);
        assert res == 12 : "Сложение не работает";
    }
}

import les1.les1_1;
import org.junit.jupiter.api.Test;

public class les1_1_Test {
    @Test
    void summTest() {
        les1_1 m = new les1_1();
        int res = m.summ(5, 7);
        assert res == 12 : "Сложение не работает";
    }
}

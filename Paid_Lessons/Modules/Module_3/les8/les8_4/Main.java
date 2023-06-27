package Paid_Lessons.Modules.Module_3.les8.les8_4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-3, -5, 0, 4, -9, 5};
        IntStream.of(50, 40, 30, 20, 10).filter(w -> w < 40 && w >= 10)
                .map(w -> w + 15) //Метод map позволяет проделывать различные операции с выбраными элементами
                .limit(3) //Метод limit пропускает только то количество элементов которое мы указали
                .forEach(System.out::println);
    }
}

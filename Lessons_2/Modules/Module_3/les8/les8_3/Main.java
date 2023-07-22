package Lessons_2.Modules.Module_3.les8.les8_3;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-3, -5, 0, 4, -9, 5};
        IntStream.of(nums).filter(w -> w > 0 && w <= 5).forEach(System.out::println);
    }
}

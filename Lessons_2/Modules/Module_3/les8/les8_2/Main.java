package Lessons_2.Modules.Module_3.les8.les8_2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-3, -5, 0, 4, -9, 6};
        int sum = IntStream.of(nums).filter(w -> w > 0).sum(); //Метод filter принимает выражение и на его основе сортирует массив, а метод sum подсчитывает отфильтрованный массив
        System.out.println(sum);


        long count = IntStream.of(nums).filter(w -> w > 0).count(); //Метод count подсчитывает колличество элементов
        System.out.println(count);
    }
}

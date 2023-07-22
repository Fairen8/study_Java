package Lessons_2.Modules.Module_1.les4;

import java.util.Arrays;

public class les4_2 {
    public static void main(String[] args) {
        byte[] nums_array = new byte[5];
        nums_array[0] = 4;
        nums_array[1] = 100;
        nums_array[2] = 50;
        nums_array[3] = 40;
        nums_array[4] = 77;

        byte[] new_array = Arrays.copyOf(nums_array, nums_array.length); //Создаём новый массив и копируем в него nums_array
        Arrays.sort(nums_array); //Сортирует массив по возрастанию
        System.out.println(Arrays.toString(nums_array)); //С помощью этой функции мы можем вывести масив
    }
}

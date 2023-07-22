package Lessons_2.Modules.Module_1.les4;

import java.util.ArrayList;

public class les4_4 {
    public static void main(String[] args) {
        ArrayList<Integer> arr_dynamic = new ArrayList<>(0);
        arr_dynamic.add(45);//Добавляет елемент в массив
        arr_dynamic.add(47);
        arr_dynamic.add(56);
        arr_dynamic.add(99);
        arr_dynamic.add(37);
        arr_dynamic.set(0, 23); //Заменяет элемент по индексу
        arr_dynamic.remove(1); //Удаляет элемент по индексу
        System.out.println(arr_dynamic.get(0)); //Выводит элемент

    }
}

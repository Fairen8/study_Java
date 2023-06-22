package Paid_Lessons.Lessons.les4;

import java.util.LinkedList;

public class les4_5 {
    public static void main(String[] args) {
        LinkedList<Integer> names = new LinkedList<>();
        names.add(45);//Добавляет елемент в массив
        names.add(47);
        names.add(56);
        names.add(99);
        names.add(37);
        names.set(0, 23); //Заменяет элемент по индексу
        names.remove(1); //Удаляет элемент по индексу
        System.out.println(names.get(0)); //Выводит элемент
    }
}

package Paid_Lessons.Modules.Module_3.les3.les3_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Course> listOfCurses = new ArrayList<>();
        listOfCurses.add(new Course("Kotlin", 1));
        listOfCurses.add(new Course("Android", 38));

        printList(listOfCurses);

        List<Lessons> listOfLessons = new ArrayList<>();
        listOfLessons.add(new Lessons("Kotlin", 1));
        listOfLessons.add(new Lessons("Android", 38));

        printList(listOfLessons);
    }

    public static void printList(List<? extends Course> list) { // ?-говорит о том что мы передаём список любого типа данных
        for (Course el : list) { //Но мы также указываем что будем передавать объекты на основе класса Course и оъекты его дочерних классов
            System.out.println(el);
        }
    }
}

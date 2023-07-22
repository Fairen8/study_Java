package Lessons_2.Modules.Module_1.les5;
import java.util.ArrayList;

public class les5_5 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(0);
        names.add("Артём");
        names.add("Оля");
        names.add("Вика");
        names.add("Дима");

        for (String el : names) {
            System.out.println(el);
        }
    }
}

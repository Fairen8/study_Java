package Lessons_2.Modules.Module_3.les6;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class les6_2 {
    public static void main(String[] args) {
        HashSet<String> hSet = new LinkedHashSet<>(); //HashSet сортирует сортирует значения, а LinkedHashSet нет
        hSet.add("banana"); //TreeSet сортирует значения по их индексу(0, 1, 2 и т.д.)
        hSet.add("milk");
        hSet.add("potato");

        hSet.add("banana"); //HashSet не сохраняет повторяющиеся элементы

        for (String str : hSet) {
            System.out.println(str);
        }
    }
}
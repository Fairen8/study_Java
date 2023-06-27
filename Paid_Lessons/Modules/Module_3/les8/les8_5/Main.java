package Paid_Lessons.Modules.Module_3.les8.les8_5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("   Me");
        list.add("You      ");
        list.add("They");

        Stream<String> stream = list.stream();

        stream   //Stream также может работать с строками
                .filter(w -> w.trim().length() == 3) //Метод trim удаляеет пробелы до и после строки
                .forEach(System.out::println);

    }
}

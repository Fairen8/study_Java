package Lessons_2.Modules.Module_3.les6;

import java.util.HashMap;
import java.util.Map;

public class les6_1 {
    public static void main(String[] args) {
        //Коллекция HashMap вместо индексов использует ключи, которые мы сами можем указать
        HashMap<String, Integer> hMap = new HashMap<String, Integer>(); //На первом месте мы указываем каким типом данных будет ключ, на втором наше значение
        hMap.put("first", 6); //HashMap по умолчанию испльзует сортировку по значениям, чтобы отключить сортировку можно использовать класс LinkedHashMap
        hMap.put("second", 2); //Так-же существует класс TreeMap, который сортирует значения по ключам
        hMap.put("thed", 5);

        int hasCar = hMap.get("second");
        System.out.println(hasCar);

        for (Map.Entry<String, Integer> entry : hMap.entrySet()) { //Перебор такого массива
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "-" + value);
        }
    }
}

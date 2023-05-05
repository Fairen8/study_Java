package Уроки.les9;
//Коллекции в Java
//ArrayList
import java.util.ArrayList;
public class les9_1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); //Создаём коллекцию и выделяем ей памать
        numbers.add(5); //Добавляем значение в коллекцию
        numbers.add(50);
        numbers.add(1, 30); //Заменяем значение 50 значением 30

//        System.out.println(numbers.size()); Выводит размерность коллекции
        System.out.println(numbers.get(1));;
//        numbers.clear(); Полностью очищает коллекцию
//        numbers.remove(1);  удаляет только указанный элемент

        for (Integer i : numbers) { //выводит все значения коллекций
            System.out.println(i);
        }
    }
}

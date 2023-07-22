package Lessons_1.les4;
//Переменные и типы данных

public class les4 {
    public static void main(String[] args){
        int age;  //Объявление числовой переменной
        age = 56; //Объявление значения переменной
        System.out.println(age);

        int ag = 46; //Более быстрый вариант
        System.out.println(ag);

        //sout + enter = System.out.println();

        System.out.println("Возраст: " + age + "."); //Объединение нескольких типов данных

        //Другие числовые переменные
        //byte от -128 до 127 байт
        //short от -32768 до 32767 2 байта
        //int от -2147483648 до 2147483647 4 байта
        //long от -9223372036854775808 до 9223372036854775807 8 байт

        float num4 = 5.2445f; //Десятичное число, f в конце обязательна

        char ch = 'H'; //переменная для хранения одного символа, обязательно в ОДИНАРНЫХ ковычках!
        System.out.println(ch);

        String name = "Alex"; //Переменная для хранения нескольких символа, обязательно в ДВОЙНЫХ ковычках!
        System.out.println(name);

        //логические переменные boolean
        boolean isHappy = true;

    }
}

package Paid_Lessons.Modules.Module_2.les2;

public class les2_2 {
    public static void main(String[] args) {
        final int num = 230; //Создание не исменяемой переменной (константы)

        System.out.println(BMW.num); //Переменная которая принадлежит к классу, а не объекту
        BMW.printTest(); //Тоже самое с функциями, она не принадлежит к объекту!
    }
}

package Paid_Lessons.Modules.Module_1.les6;
//Функции
public class les6_1 {
    public static void main(String[] args) {
        String[] name_1 = new String[] {"Игорь", "Артём", "Николай"};
        String[] name_2 = new String[] {"Александр", "Григорий", "Ваня", "Савва", "Игорь"};
        int a = 95;
        printSome(a, name_1);
        printSome(22, name_2);
    }

    public static void printSome(int some, String[] arr) {
        System.out.println("Переменная: " + some);
        for (String s : arr) { //Сокращённая версия перебора массива
            System.out.println("Значение элемента: " + s);
        }
    }
}

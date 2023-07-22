package Lessons_1.les5;
//Примитивный калькулятор
import java.util.Scanner;

public class les5_3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите 1 число: ");
        float num1 = scan.nextFloat(); //Получаем от пользователя первое число

        System.out.println("Введите 2 число: ");
        float num2 = scan.nextFloat(); //Получаем от пользователя второе число

        float res1 = num1 + num2; //Выполняем сложение
        float res2 = num1 - num2; //Выполняем вычитание
        float res3 = num1 * num2; //Выполняем умножение
        float res4 = num1 / num2; //Выполняем деление

        System.out.println("Результат: ");
        System.out.println(res1 + "\n" + res2 + "\n" + res3 + "\n" + res4); //Показываем результат пользователю
        //В результате мы получаем числа с нулём после точки, это связанно с тем, что мы используем переменую типа float-переменная для десятичных дробей
    }
}

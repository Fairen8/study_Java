package Lessons_1.les5;
//Данные от пользователя

import java.util.Scanner;  //Импортируем встроенну библиотеку
public class les5_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Создаём новый объект и выделеям ему память
        System.out.print("Введите ваше имя: "); //Говорим пользователю что нужно ввести
        String name = scan.nextLine(); //Получаем ввод от пользователя с помощью nextLine() и сохраняем его в переменную
        System.out.println("Привет, " + name);
        int num1 = scan.nextInt(); //Получаем от пользователя ЧИСЛО, с помощью nextInt, но если он введёт строку мы получим ошибку, позже мы будем пользоваться исключениями
        //Для каждого типа данных существует свой метод

    }
}

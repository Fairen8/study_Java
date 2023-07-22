package Lessons_2.Modules.Module_3.les2.les2_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Proccess ob = new Proccess();
        ob.start(); //Начало второго потока

        System.out.println("Нажмите на любую клавишу: "); //Продолжение первого потока
        Scanner in = new Scanner(System.in);
        in.nextLine();
        /* Работа нескольких потоков позволяет нам отслеживать нажал ли пользователь кнопку
        * и одновременно с этим выводить сообщение в консоль*/

        ob.exit();
    }
}

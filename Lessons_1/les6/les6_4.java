package Lessons_1.les6;
//Условные конструкции
//Оператор switch-case

import java.util.Scanner;
public class les6_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){ //Оператор switch проверят переменную на несколько значений
            case 1:  //Случай, если условие верно, то выполнется код от двоеточия до слова break
                System.out.println("Number is 1");
                break;
            case 2:
                System.out.println("Number is 2");
                break;
            case 5:
                System.out.println("Number is 5");
                break;
            default: //Замена else в операторе switch-case
                System.out.println("Default");
        }
    }
}

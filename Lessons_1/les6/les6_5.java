package Lessons_1.les6;
//Условные конструкции
//Более продвинутый калькулятор
import java.util.Scanner;

public class les6_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1 число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите 2 число: ");
        int num2 = scanner.nextInt();

        System.out.print("Действие: ");
        String action = scanner.nextLine();
        action = scanner.nextLine();  //Из-за особенностей Java он подставляет значение в 16 сторку, в 17 строке мы повторно запрашиваем данные пользователя

        int res;

        switch (action){
            case "+":
                res = num1 + num2;
                System.out.println("Результат: " + res);
                break;
            case "-":
                res = num1 - num2;
                System.out.println("Результат: " + res);
                break;
            case "*":
                res = num1 * num2;
                System.out.println("Результат: " + res);
                break;
            case "/":
                if (num2 == 0){
                    System.out.println("Error");
                }
                else {
                    res = num1 / num2;
                    System.out.println("Результат: " + res);
                }
                break;
            default:
                System.out.println("Вы что-то не то ввели");
        }
    }
}

package Paid_Lessons.Modules.Module_1.les3;
//Условные операторы
import java.util.Scanner;
public class les3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        boolean isTrue = true;
        if (isTrue) {
            System.out.println("Всё сработало");
        }
        if (num == 10) {
            System.out.println("Переменная равна 10");
        }
    }
}

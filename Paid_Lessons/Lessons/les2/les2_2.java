package Paid_Lessons.Lessons.les2;
import java.util.Scanner;
public class les2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число ");
        int num = in.nextInt();
        System.out.println(num);

        char symbol = in.next().charAt(0);
        System.out.printf(String.valueOf(symbol));
    }
}

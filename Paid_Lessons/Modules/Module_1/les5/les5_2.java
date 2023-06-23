package Paid_Lessons.Modules.Module_1.les5;

import java.util.Scanner;

public class les5_2 {
    public static void main(String[] args) {
        byte user_input;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите число 5: ");
            user_input = in.nextByte();
        } while (user_input != 5);
        System.out.println("Вы молодец!");
    }
}

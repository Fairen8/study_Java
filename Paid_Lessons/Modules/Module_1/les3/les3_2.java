package Paid_Lessons.Modules.Module_1.les3;

import java.util.Scanner;

public class les3_2 {
    public static void main(String[] args) {
        System.out.print("Введите ваш возраст: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();

        if (age < 18) {
            System.out.println("Вы ещё слишком малы");
        } else if (age >= 18 && age <= 20) {
            System.out.println("Вам уже " + age + " лет");
        }else {
            System.out.println("Вам уже " + age + " год");
        }
    }
}

package Paid_Lessons.Lessons.les6;

import java.util.Scanner;

public class les6_4 {
    public static void main(String[] args) {
        String[] names = new String[3];
        String[] names_2 = new String[3];
        int[] age = new int[3];
        makeArr(names);
        makeArr(names_2);
        makeArr(age);

        printArr(names);
        printArr(names_2);
        printArr(age);
    }

    public static String[] makeArr(String[] arr) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Введите " + (i + 1) + " элемент: ");
            arr[i] = in.nextLine();
        }
        return arr;
    }
    public static int[] makeArr(int[] arr) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Введите " + (i + 1) + " элемент: ");
            arr[i] = in.nextInt();
        }
        return arr;
    }
    public static void printArr(String[] arr) {
        for (String s : arr) {
            System.out.println("Значение элемента: " + s);
        }
    }
    public static void printArr(int[] arr) {
        for (Integer s : arr) {
            System.out.println("Значение элемента: " + s);
        }
    }
}

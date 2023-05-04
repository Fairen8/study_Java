package Уроки.les8;
//Массывы Данных
//Практическое применение
import java.util.Scanner;
public class les8_3 {
    public static void main(String[] args) {
        int[] arr = new int[4];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Введите число: "); //Просим пользователя заполнить массив
            int value = scanner.nextInt();
            arr[i] = value;
        }

        int min = arr[0];

        for(int i = 0; i < arr.length; i++) { //Перебераем массив в поисках минимального числа
            if (arr[i] < min) {
                min = arr[i];

            }

        }
        System.out.println("Minimal: " + min);
    }
}

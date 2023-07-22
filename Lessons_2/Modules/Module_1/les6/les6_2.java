package Lessons_2.Modules.Module_1.les6;

public class les6_2 {
    public static void main(String[] args) {
        String[] name_2 = new String[] {"Александр", "Григорий", "Ваня", "Савва", "Игорь"};
        int[] num = new int[] {5, 35, 657, 46, 686};
        printArr(name_2);
        printArr(num);
        printSome();
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
    public static void printSome() {
        System.out.println("Hello world");
    }
}

package Lessons_2.Homework.Module_1;

public class Homework_1 {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0)
                result += i;
            else if (i % 3 == 0)
                result += i;
        }
        System.out.print("Результат: " + result);
    }
}

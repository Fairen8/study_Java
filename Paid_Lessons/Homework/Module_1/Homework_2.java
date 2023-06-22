package Paid_Lessons.Homework.Module_1;

public class Homework_2 {
    public static void main(String[] args) {
        int[][] x = {
                {20, 34, 2},
                {9, 12, 18},
                {3, 4, 5}
        };
        int min = x[0][0];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (min > x[i][j])
                    min = x[i][j];
            }
        }
        System.out.print("Минимальное число в массиве: " + min);
    }
}

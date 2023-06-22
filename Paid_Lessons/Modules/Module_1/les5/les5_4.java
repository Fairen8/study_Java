package Paid_Lessons.Lessons.les5;

public class les5_4 {
    public static void main(String[] args) {
        int[][] big_nums = new int[][] {
                {5, 746, 2, 825},
                {2, 57, 743, 367},
                {52, 3, 26, 476},
                {26, 75, 5, 883},
                {266, 11, 0, 457}
        };

        for (int i = 0; i < big_nums.length; i++) {
            for (int j = 0; j < big_nums[i].length; j++) {
                System.out.println(big_nums[i][j] + "  " + i + " " + j);
            }
        }
    }
}

package Lessons_1.les8;
//Многомерные масивы данных
public class les8_4 {
    public static void main(String[] args) {
        char[][] syms = new char[2][2];
        syms[0][0] = 't';
        System.out.println(syms[0][0]);

        byte[][] nums = new byte[][] {
                {5, 7},
                {7, 3},
                {2, 0}
        };

        nums[1][1] = 67;
        System.out.println(nums[1][1]);
    }
}

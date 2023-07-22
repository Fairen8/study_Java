package Lessons_2.Modules.Module_3.les8.les8_1;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-3, -5, 0, 4, -9, 6};
        int sum = 0;
        for (int i : nums)
            if(i > 0)
                sum += i;
        System.out.println(sum);
    }
}

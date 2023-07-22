package Lessons_2.Modules.Module_3.les5.les5_2;


public class les5_2 {
    public static void main(String[] args) {
        IMath iMath = new IMath() {
            @Override
            public int summ(int a, int b) {
                int sum = a + b;
                return sum;
            }
        };

        System.out.println(iMath.summ(5, 7));

        IMath iMath1 = (a, b) -> a + b;
        System.out.println(iMath1.summ(6, 7));
    }
}

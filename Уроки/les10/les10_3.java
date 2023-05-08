package Уроки.les10;

public class les10_3 {
    public static void main(String[] args) {
        byte[] nums1 = new byte[] {5, 6, 8};

        int summ1 = summaArray(nums1);
        System.out.println("Сумма 1: " + summ1);

    }

    public static int summaArray(byte[] arr) {
        int summa = 0;
        for(byte i = 0; i < arr.length; i++) {
            summa += arr[i];
        }
        return summa;
    }
}

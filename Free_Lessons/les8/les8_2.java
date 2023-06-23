package Free_Lessons.les8;
//Массивы данных
public class les8_2 {
    public static void main(String[] args) {
        float[] nums2 = new float[] {5.0f, 6.45f, 89.984f}; //Сразу объявляем размер масива и его переменные
        System.out.println(nums2[1]);

        for (int i =0; i < nums2.length; i++){ //Для вывода всех значений массива используют циклы. Чтобы в ручную не считать количество элементов, обращаемся к массиву и используем метод length, который показывает количество элементов в массиве
            System.out.println("Element: " + nums2[i]);

        }


    }
}

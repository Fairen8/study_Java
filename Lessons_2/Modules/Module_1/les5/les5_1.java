package Lessons_2.Modules.Module_1.les5;
//Циклы
public class les5_1 {
    public static  void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
        int g = 100;
        do {
            System.out.println("Цикл сработал");
            g /= 2;
        } while (g > 10);
    }
}

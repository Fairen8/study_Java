package Lessons_2.Modules.Module_1.les5;

public class les5_7 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            if (i % 2 == 0)  {
                i++;
                continue; //Пропускает только один цикл
            }
            System.out.println(i);
            i++;
        }
    }
}


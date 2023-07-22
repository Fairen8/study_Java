package Lessons_2.Modules.Module_3.les1.les1_2;

public class NewTest implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Элемент: " + i);
        }
    }
}

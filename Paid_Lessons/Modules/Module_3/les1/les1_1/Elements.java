package Paid_Lessons.Modules.Module_3.les1.les1_1;

public class Elements extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Элемент: " + i);
        }
    }
}

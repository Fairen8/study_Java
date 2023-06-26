package Paid_Lessons.Modules.Module_3.les1.les1_3;

public class Main {
    public static void main(String[] args) {
        Thread ob_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("Элемент: " + i);
                }
            }
        });
        Thread ob_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("Элемент: " + i);
                }
            }
        });

        ob_1.start();
        ob_2.start();

    }
}

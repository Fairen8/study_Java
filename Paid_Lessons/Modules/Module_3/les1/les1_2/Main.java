package Paid_Lessons.Modules.Module_3.les1.les1_2;

public class Main {
    public static void main(String[] args) {
        Thread ob_1 = new Thread(new NewTest());
        ob_1.start();

        Thread ob_2 = new Thread(new NewTest());
        ob_2.start();
    }
}

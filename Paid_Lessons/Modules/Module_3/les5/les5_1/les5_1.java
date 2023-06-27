package Paid_Lessons.Modules.Module_3.les5.les5_1;

public class les5_1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable runnable1 = () -> System.out.println("Hello"); //Сокращённая версия записи вложеных классов
    }
}

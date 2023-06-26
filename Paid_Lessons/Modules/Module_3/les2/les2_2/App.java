package Paid_Lessons.Modules.Module_3.les2.les2_2;

public class App {

    private int count = 0;

    public synchronized void increment() { //Функция для синхронизации двух потоков с атрибутом synchronized
        count++;
    }
    public static void main(String[] args) {
        App app = new App();
        app.doSome();
    }
    public void doSome() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment(); //Для простого действия вызываем функцию, т.к. она синхронизирует оба наших потока и мы получаем ожидаемый результат
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join(); //Присоеденяем поток к основному
            t2.join(); //Присоеденяем поток к основному
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }
}

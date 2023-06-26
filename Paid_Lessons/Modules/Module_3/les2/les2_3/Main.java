package Paid_Lessons.Modules.Module_3.les2.les2_3;

public class Main {
    public static void main(String[] args) throws InterruptedException { //Чтобы функция обработала коректно указываем обрабутку ошибки
        final Car bmw = new Car(); //final не даст нам как либо изменять объект

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bmw.moveCar();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bmw.stopeCar();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

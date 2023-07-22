package Lessons_2.Modules.Module_3.les2.les2_3;

import java.util.Scanner;

public class Car {

    public void moveCar() throws InterruptedException { //throws указывает обработку ошибки InterruptedException для всей функции
        synchronized (this) { //Указываем synchronized внутри функции и указываем с чем мы синхронизируемся, в данном случаем this указывает что мы синхронизируем код внутри класса
            System.out.println("Машина в движении");
            wait(); //Приостонавливаем поток до получения сигнала от функции notify
            System.out.println("Машина остановлена!");
        }
    }
    public void stopeCar() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Нажмите что-либо для остановки машины");
            in.nextLine();
            notify(); //Посылает сигнал в другой поток для возобновления
            //Для корректной работы необходима синхронизация потоков
        }
    }
}

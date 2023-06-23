package Paid_Lessons.Modules.Module_2.les4;

abstract class Car {
    protected short speed;
    private String model;
    private float weight;
    private String color;
    private boolean isWork;

    Driving engine = new Driving(true);

    Car(String model, float weight, String color, boolean isWork) {
        this.model = model;
        this.weight = weight;
        this.color = color;
        this.isWork = isWork;
    }

    void printAll() {
        String isWork = this.isWork ? "работает" : "не работает";
        System.out.println("Автомобиль марки: " + this.model +
                "\nЦвет: " + this.color +
                "\nВес: " + this.weight +
                "\nСкорость: " + this.speed +
                "\nИ он " + isWork);
    }

    abstract void startEngine();
    class Driving { /*Вложенный класс используется для реализации большого функционала внутри
    основного класса. Он вовсе не обязательный,
    но используется в основном для организации кода*/
        private boolean isDrive;

        Driving(boolean isDrive) {
            this.isDrive = isDrive;
        }

        void drive() {
            System.out.println(this.isDrive);
        }
    }
}


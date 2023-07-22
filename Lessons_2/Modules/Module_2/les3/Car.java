package Lessons_2.Modules.Module_2.les3;

abstract class Car { //С помощью абстрактных классов нельзя создавать объекты
    protected short speed;
    private String model;
    private float weight;
    private String color;
    private boolean isWork;

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

    abstract void startEngine(); //Абстрактные обязательно должны быть реализованы в классах наследниках
                                 //Но не мгут быть реализованы в супер классе
}

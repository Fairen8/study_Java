package Lessons_2.Modules.Module_2.les1;

public class Car {
    public short speed;
    private String model;
    private float weight;
    private String color;
    private boolean isWork;

    Car(String model, float weight, String color, boolean isWork) {
        this.model = model;
        this.weight = weight;
        this.color = color;
        this.isWork = isWork;
        printAll();
    }

    Car() {
        System.out.println("Обьект был создан");
    }

    void settAll(String model, float weight, String color, boolean isWork) {
        this.model = model;
        this.weight = weight;
        this.color = color;
        this.isWork = isWork;
    }

    private void printAll() {
        String isWork = this.isWork ? "Работает" : "Не работает";
        System.out.println("Автомобиль марки: " + this.model +
                "\nЦвет: " + this.color +
                "\nВес" + this.weight +
                "\nСкорость" + this.speed +
                "\nИ он " + isWork);
    }

}

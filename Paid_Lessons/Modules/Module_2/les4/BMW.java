package Paid_Lessons.Modules.Module_2.les4;

public class BMW extends Car {
    private boolean isMPerfomance = false;
    public static int num = 20;

    BMW(boolean isMPerfomance, String model, float weight, String color, boolean isWork, short speed) {
        super(model, weight, color, isWork);
        this.isMPerfomance = isMPerfomance;
        super.speed = speed;
    }

    void printAll() {
        super.printAll();
        String isMPerfomance = this.isMPerfomance ? "является" : "не является";
        System.out.println("Машина " + isMPerfomance + " М перфоманс");
        super.engine.drive();
    }

    @Override
    void startEngine() {
        System.out.println("Машина заведина c кнопки!");
    }

    public static void printTest () {
        System.out.println("Тест");
    }
}


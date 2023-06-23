package Paid_Lessons.Modules.Module_2.les1;

public class les1_1 {
    public static void main(String[] args) {
        Car bmw = new Car("M3", 1238.5f, "Белый", true);
        bmw.speed = 230;
//        bmw.settAll("M3", 1238.5f, "Белый", true);
//        System.out.println(bmw.speed);

        Car mercedes = new Car();
        mercedes.speed = 320;
        mercedes.settAll("S500", 31238.5f, "Чёрный", false);
//        System.out.println(mercedes.speed);
    }
}

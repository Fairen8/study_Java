package Уроки.les13;
//Конструкторы класса
public class les13_1 {
    public static void main(String[] args) {
        Transport bmw = new Transport(250.5f, 2500, "White", new byte[] {0, 0, 0});

        Transport truck = new Transport(5600, new byte[] {110, 0, 110});
//        truck.speed = 140.5f;
//        truck.weight = 5600;
//        truck.color = "Red";
//        truck.coordinate = new byte[] {110, 0, 110};
//
//        String res2 = truck.getValues();
//        System.out.println(res2);
    }
}

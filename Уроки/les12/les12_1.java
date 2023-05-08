package Уроки.les12;
//ООП: классы и объекты
public class les12_1 {
    public static void main(String[] args) {
        les12_2 bmw = new les12_2();
        bmw.setValues(250.5f, 2500, "White", new byte[] {0, 0, 0});
        String res1 = bmw.getValues();
        System.out.println(res1);

        les12_2 truck = new les12_2();
        truck.speed = 140.5f;
        truck.weight = 5600;
        truck.color = "Red";
        truck.coordinate = new byte[] {110, 0, 110};

        String res2 = truck.getValues();
        System.out.println(res2);
    }
}

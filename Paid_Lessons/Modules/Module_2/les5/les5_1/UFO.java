package Paid_Lessons.Modules.Module_2.les5.les5_1;

public class UFO implements HumenInterface {
    private int age;

    UFO(int age) {
        this.age = age;
    }
    @Override
    public void talk() {
        System.out.println("Привет, я инопланетное существо и я могу говорить!");
    }

    @Override
    public void walk() {
        System.out.println("Привет, я инопланетное существо и я могу ходить!");
    }

    @Override
    public int getAge() {
        return this.age;
    }
}

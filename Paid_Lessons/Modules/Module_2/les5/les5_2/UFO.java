package Paid_Lessons.Modules.Module_2.les5.les5_2;

public class UFO implements HumenInterface {
    private int age;
    private Personality person;

    UFO(int age, Personality person) {
        this.age = age;
        this.person = person;
    }
    @Override
    public void talk() {
        System.out.println("Привет, я инопланетное существо и я могу говорить!");
        System.out.println("Персона: " + this.person);
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

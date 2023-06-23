package Paid_Lessons.Modules.Module_2.les5.les5_2;

public class Main {
    public static void main(String[] args) {
        Person bob = new Person(23, Personality.MALE);
        System.out.println(bob.getAge());
        bob.talk();

        UFO alien = new UFO(823, Personality.ALIEN);
        System.out.println(alien.getAge());
        alien.talk();
    }
}

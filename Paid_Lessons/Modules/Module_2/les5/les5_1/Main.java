package Paid_Lessons.Modules.Module_2.les5.les5_1;

public class Main {
    public static void main(String[] args) {
        Person bob = new Person(23);
        System.out.println(bob.getAge());
        bob.talk();

        UFO alien = new UFO(823);
        System.out.println(alien.getAge());
        alien.talk();
    }
}

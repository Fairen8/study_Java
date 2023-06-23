package Paid_Lessons.Modules.Module_2.les5.les5_2;

public class Person implements HumenInterface {
    private int age;
    private Personality person;

    Person(int age, Personality person) {
        this.age = age;
        this.person = person;
    }
    @Override
    public void talk() {
        System.out.println("Привет, я могу говорить!");
        System.out.println("Персона: " + this.person);
    }

    @Override
    public void walk() {
        System.out.println("Привет, я могу ходить!");
    }

    @Override
    public int getAge() {
        return this.age;
    }
}

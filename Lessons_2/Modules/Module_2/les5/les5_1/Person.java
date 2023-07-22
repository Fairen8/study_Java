package Lessons_2.Modules.Module_2.les5.les5_1;

public class Person implements HumenInterface {
    private int age;

    Person(int age) {
        this.age = age;
    }
    @Override
    public void talk() {
        System.out.println("Привет, я могу говорить!");
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

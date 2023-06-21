package Lessons.les18;
//Пакеты, перегрузки, модификатор static

import Lessons.les18.db.DB;
public class les18_1 {
    public static void main(String[] args) {

        final int count = 10;

        DB db = new DB();
        Person ob1 = new Person();
        Person ob2 = new Person();
        Person.getCount();
        Person ob3 = new Person();
        Person.getCount();
        Person ob4 = new Person();
        Person.getCount();
//        Person.count = 5;
//        System.out.println(Person.count);

//        info("Hello World", 5.4f);

//        System.out.println();
     }

     public final static void info() {
         System.out.println("Hello");
     }

    public static void info(String word) {
        System.out.println(word + "!");
    }

    public static void info(String word, float wor2) {
        System.out.println(word + "!");
    }
}

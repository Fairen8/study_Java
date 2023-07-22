package Lessons_2.Modules.Module_3.les3.les3_2;


public class Main {
    public static void main(String[] args) {
        Course android = new Course("Android", 38);
        Course kotlin = new Course("Kotlin", 38);
        System.out.println(android);
        System.out.println(kotlin);
        System.out.println(android.equals(kotlin)); //equals используется для сравнения объектов, но эту функцию необходимо переопределить

        String str = "Hello";
        String str_2 = "Hello";

        System.out.println(str.equals(str_2));
    }
}

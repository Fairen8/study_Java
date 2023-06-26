package Paid_Lessons.Modules.Module_3.les3.les3_1;


public class Main {
    public static void main(String[] args) {
        Course newCourse = new Course("Android", 38);
        System.out.println(newCourse.getClass()); //getClass выводит класс с которым мы взаимодействуем
        System.out.println(newCourse.hashCode()); //hashCode выводит индификатор, который писвоен к определёнуму объекту
        System.out.println(newCourse.toString()); //toString приводит значения в формат строки(При попыткее вывести объект используется по умолчанию). Также эту функцию можно переопределить и выводить нужную нам информацию

    }
}

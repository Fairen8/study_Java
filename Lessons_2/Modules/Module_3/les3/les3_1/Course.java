package Lessons_2.Modules.Module_3.les3.les3_1;

public class Course {
    private String title;
    private int id;
    public Course(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String toString() { //Переопределяем функцию toString
        return id + "-" + title;
    }

}

package Lessons_2.Modules.Module_3.les3.les3_3;

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

    public boolean equals(Object ob) {
        Course course = (Course) ob;
        return id == course.id;
    }

}

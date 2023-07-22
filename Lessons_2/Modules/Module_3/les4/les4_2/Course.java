package Lessons_2.Modules.Module_3.les4.les4_2;

import java.io.Serializable;

public class Course implements Serializable {
    private String title; //Чтобы не Сериалировать определённое поле можно добавить к нему модификатор transient
    private int id;
    public Course(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String toString() {
        return id + "-" + title;
    }

    public boolean equals(Object ob) {
        Course course = (Course) ob;
        return id == course.id;
    }

}


package Lessons_2.Modules.Module_3.les4.les4_1;

import java.io.Serializable;

public class Course implements Serializable {
    private String title;
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


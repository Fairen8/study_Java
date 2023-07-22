package Lessons_2.Homework.Module_3;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String login;
    private byte age;
    private List<String> hobby;

    public User() {}

    public User(String name, String login, byte age, List<String> hobby) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobby = hobby;
    }
    public String toString() {
        String hob = "\n";
        for (String el : hobby)
            hob += el.trim() + "\n";
        return "Пользователь: " + name + " с логином: " + login + ". Его возраст: " + age + ". Все хобби: " + hob;
    }
}

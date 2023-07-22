package Lessons_2.Homework.Module_3;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = in.nextLine();

        System.out.print("Введите логин: ");
        String login = in.nextLine();

        System.out.print("Введите возраст: ");
        byte age = in.nextByte();

        System.out.print("Введите хобби через запятую: ");
        String hobby_1 = in.nextLine();
        String hobby = in.nextLine();

        User user = new User(name, login, age, List.of(hobby.split(",")));

        try {
            FileOutputStream fos = new FileOutputStream("Lessons_2/Homework/Module_3/some.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(user);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("Lessons_2/Homework/Module_3/some.data");
            ObjectInputStream ois = new ObjectInputStream(fis);

            User obj = (User) ois.readObject();

            System.out.println(obj);

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

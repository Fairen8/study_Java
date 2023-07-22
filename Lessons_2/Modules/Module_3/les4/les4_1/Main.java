package Lessons_2.Modules.Module_3.les4.les4_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    //В этом классе мы записываем данные в файл
    public static void main(String[] args) {
        Course ob = new Course("Kotlin", 1);
        Course android = new Course("Android", 5);

        try {
            FileOutputStream fos = new FileOutputStream("Lessons_2/Modules/Module_3/les4/les4_1/main.i"); //Файл может иметь любое расширение
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            oos.writeObject(android);
            oos.writeObject(ob);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

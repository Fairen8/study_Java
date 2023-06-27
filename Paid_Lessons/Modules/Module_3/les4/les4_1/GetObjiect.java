package Paid_Lessons.Modules.Module_3.les4.les4_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetObjiect {
    //В этом классе мы извлекаем данные из файла
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Paid_Lessons/Modules/Module_3/les4/les4_1/main.i");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Course android = (Course) ois.readObject();
            Course kotlin = (Course) ois.readObject();

            System.out.println(android);
            System.out.println(kotlin);

            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

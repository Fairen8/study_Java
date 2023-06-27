package Paid_Lessons.Modules.Module_3.les4.les4_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class GetObjiect {
    //В этом классе мы извлекаем данные из файла
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Paid_Lessons/Modules/Module_3/les4/les4_2/main.i");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Course[] ob = (Course[]) ois.readObject();

            System.out.println(Arrays.toString(ob));

            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

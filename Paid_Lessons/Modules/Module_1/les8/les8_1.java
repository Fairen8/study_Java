package Paid_Lessons.Modules.Module_1.les8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class les8_1 {
    public static void main(String[] args) {
        File file = new File("Paid_Lessons/Modules/Module_1/les8/text.txt");

        if (!file.exists())  /*Если этого файла не существует*/ {
            try {
                file.createNewFile(); //Создаём новый файл и проверяем ошибки
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            PrintWriter pw = new PrintWriter(file); //Создаём объект с помощью которго сможем делать записи в файл
            Scanner in = new Scanner(System.in);
            String user_input = in.nextLine();   //Получаем данные от пользователя
            pw.println(user_input);              //И заносим их в наш файл

            pw.close(); //Закрываем файл, это обязательно!
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

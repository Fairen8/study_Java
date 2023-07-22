package Lessons_2.Modules.Module_1.les8;

import java.io.*;
import java.util.Scanner;

public class les8_2 {
    public static void main(String[] args) {
        File file = new File("Lessons_2/Modules/Module_1/les8/text.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String con = fileRead(); //Переменная которая хранит в себе все предыдущие записи файла
        try {                    //Это нужно сделать для того что-бы файл записывал новые данные, а не переписывал предыдущие
            PrintWriter pw = new PrintWriter(file);
            Scanner in = new Scanner(System.in);
            String user_input = in.nextLine();
            con += user_input; //Добавляем новые записи
            pw.println(con);

            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fileRead());

    }
    public static String fileRead() {
        BufferedReader br = null;
        String result = "";
        try {
            //Создаём объект с помощью которого будем читать информацию из файла
            br = new BufferedReader(new FileReader("Lessons_2/Modules/Module_1/les8/text.txt"));

            String line;
            while ((line = br.readLine()) != null){ //Делаем проверку что-бы остановиться на пустой строке
                result += line + "\n"; //Сумируем все строки
            }
            br.close(); //Обязательн закрываем файл
        } catch (IOException e) { //IOException - все ошибки связанные с работой с файлами
            throw new RuntimeException(e);
        }
        return result;
    }
}

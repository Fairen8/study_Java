package Free_Lessons.les6;

import java.util.Scanner;

//Условные конструкции
//Практическое применение
public class les6_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите роль: ");
        String role = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String pass = scanner.nextLine();

        if(role.equals("Admin") && pass.equals("12345")){ //equals используется для сравнения строк, == для их сравнения не подойдёт
            System.out.println("Все пользователи");
        } else {
            System.out.println("Привет, как вас зовут?");
            String name = scanner.nextLine();
        }

    }
}

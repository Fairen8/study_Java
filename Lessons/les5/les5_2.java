package Lessons.les5;
//Операции
import java.util.Scanner;

public class les5_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        short num1 = 50, num2 = 11; //Объявляем две переменные и присваиваем им значения
        int res = num1 % num2;      //%-оператор остаток при делении, результат мы записываем в переменую res
        System.out.println("Результат: " + res);

        res += 10; //К переменной res мы добавляем 10, можно использовать и res = res + 10, результат один!
        System.out.println("Результат + 10: " + res);

        res = num1 % num2;
        res++; //К переменной добаляется единица, можно записать и другим образом - res+= 1, res-- анологично, но мы отнимаем единицу
        System.out.println("Результат + 1: " + res);
    }
}

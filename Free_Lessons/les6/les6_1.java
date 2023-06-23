package Free_Lessons.les6;
//Условные конструкции
public class les6_1 {
    public static void main(String[] args) {
        int a = 15, b = 10;
        if (a > b) {         //Если a больше чем b, выполняется код внутри фигурных скобок, для проверки на равенство используется ==
            System.out.println(a + " > " + b);
        }
        boolean isHasCar = false;
        if (isHasCar) {          //Если переменная isHasCar = true, Выполняется код внутри фигурных скобок. Для обратного сравнения перед переменной ставится !
            System.out.println("Да, верно");
        } else if (a >= b) {     //Дополнительное условие (их может быть несколько), если первое условие оказалось верным доп. условие игнорируется
            System.out.println("Second test");
        } else {                 //Выполняет код в случае если основные условие оказалось неверными
            System.out.println("Нет,не верно");
        }
    }
}

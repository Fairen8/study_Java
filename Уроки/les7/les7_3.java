package Уроки.les7;
//Циклы
//do while
public class les7_3 {
    public static void main(String[] args){
        int i = 100;
        do { //цикл do сначало выполняет код, а потом проверяет условие. Если условие верно цикл повтаряется
            System.out.println("Element: " + i);
            i*=100;
        } while (i < 10);
    }
}

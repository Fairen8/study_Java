package Уроки.les7;
//Циклы
//Операторы
public class les7_4 {
    public  static void main(String[] args) {
        for (int i = 5; i < 25; i += 2) {

            if (i % 3 == 0) {
                continue; //Оператор continue при срабатывание пропускает код после себя и повторяет цикл
            }
            if(i >= 17) {
                break; //При достижении числа 17 оператор break выходит из цикла
            }
            System.out.println("Element: " + i);
        }
    }
}

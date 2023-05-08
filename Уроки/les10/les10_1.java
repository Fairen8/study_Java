package Уроки.les10;
//Методы
public class les10_1 {
    public static void main(String[] args){
        info("Hello"); //Вызываем метод
        String java = "Java";
        info(java);

        summa((short) 5, (short) 7);

    }

    public static void summa(short a, short b) {
        int res = a + b;
        String result = "Результат: " + res;
        info(result);
    }

    public static void info(String word) { //Объявляем новый метод
        System.out.print(word);
        System.out.println("!");

    }
}

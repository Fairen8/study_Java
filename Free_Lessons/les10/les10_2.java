package Free_Lessons.les10;
//Методы
public class les10_2 {
    public static void main(String[] args){
        int result = summa((short) 5, (short) 7);
        info(String.valueOf(result));

    }

    public static int summa(short a, short b) {
        int res = a + b;
        String result = "Результат: " + res;
        return res;
    }

    public static void info(String word) {
        System.out.print(word);
        System.out.println("!");

    }
}

package Lessons_2.Modules.Module_1.les7;

public class les7_1 {
    public static void main(String[] args) {
        float[] arr = new float[] {5.3f, 66.46f, 264.46f,};

        try { //Блок в котором отслеживаются ошибки
            System.out.println(arr[3]);
            int res = 100 / 0;
        } catch (ArrayIndexOutOfBoundsException e) { //Блок действий в случае ошибки
            System.out.print("Ошибка: " + e); //е объект в который схраняется ошибка
        } catch (ArithmeticException e) { //Проверка на несколько ошибок
            System.out.print("Ошибка: " + e); //Exception - все исключения
        }finally {
            /*
            Блок который срабатывает в любом случае
            после завершения блока try
            или
            после завершения блока catch
             */
            System.out.print("сработал блок finally");
        }

    }
}

package Paid_Lessons.Modules.Module_2.les6;


public class Child extends Base {
    /*Анотации являются подписями наших действи в коде.
    Они используются для большей читаемости кода*/
    @MyI(num = 4, name = "Alexandr", digit = 5.4f, type = MyI.Tupes.Hard) //Использование моей анотации
    @Override //Например Override говорит там о том что мы переписываем метод из супер класса
    @Deprecated //Deprecated используется для обозначения устаревших методов
    //Анотаций может быть не ограниченное количество
    public void print(String info) {
        System.out.println("Результат: " + info);
    }
}

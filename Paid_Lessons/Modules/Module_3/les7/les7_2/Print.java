package Paid_Lessons.Modules.Module_3.les7.les7_2;

public class Print<T> { //Указываем что нам не известен тип данных и  при получении мы как-бы передаём его в переменной для функций, полей и тд
    //Неизвестных типов данных может быть несколько
    private T info;
    private String data;

    public void setInfo(T info) {
        this.info = info;
    }
    public T getInfo() {
        return this.info;
    }

    public String printdata() {
        return data;
    }

    public <T1> void print(T1[] items) { //Добавление джинерика отдельно от класса в метод
        for (T1 item : items) {
            System.out.println(item);
        }
    }
}

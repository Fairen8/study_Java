package Lessons_2.Modules.Module_3.les7.les7_3;

public class Print<T> {
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

    public <T1, T2> T2 print(T1[] items, T2 info) {
        for (T1 item : items) {
            System.out.println(item);
        }

        return info;
    }
}

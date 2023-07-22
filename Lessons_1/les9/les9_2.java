package Lessons_1.les9;
//Коллекции в Java
//LinkedList
import java.util.LinkedList;
public class les9_2 {
    public static void main(String[] args) {
        LinkedList<Float> num = new LinkedList<>(); //По работе очень схож с ArrayList, но больше подходит для изменений
        num.add(5.5f);
        num.add(15.26f);
        num.add(50.534f);

        for (Float l : num)
            System.out.println(l);
    }
}

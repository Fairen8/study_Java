package Free_Lessons.les18;

public final class Person {

    private static int count;

    public Person() {
        count++;
    }

    public static void getCount() {
        System.out.println("Количество: " + count);
    }
}

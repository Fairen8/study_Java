package Lessons_2.Modules.Module_3.les7.les7_2;

public class Main {
    public static void main(String[] args) {
        Print<String> print1 = new Print<>();
        print1.setInfo("First");
        System.out.println(print1.getInfo());

        Print<Integer> print2 = new Print<>();
        print2.setInfo(4);
        System.out.println(print2.getInfo());

        print1.print(new String[] {"Tom", "Alex", "Bob"});

        print2.print(new Integer[] {3, 6, 86});
    }


}

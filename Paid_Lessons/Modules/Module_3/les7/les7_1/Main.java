package Paid_Lessons.Modules.Module_3.les7.les7_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List info = new ArrayList();
        info.add("First");
        info.add(2);

        for(Object el : info) {
            System.out.println(el);
        }
    }
}

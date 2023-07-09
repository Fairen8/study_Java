package les5;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Item item = ItemService.getItem(1);
        System.out.println(item.getName());
    }

}

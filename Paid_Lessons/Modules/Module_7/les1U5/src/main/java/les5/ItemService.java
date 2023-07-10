package Paid_Lessons.Modules.Module_7.les1U5.src.main.java.les5;

import java.util.List;

public class ItemService {

    private static final ItemDAO _itemDAO = new ItemDAO();

    public static int add(Item item) {
        return _itemDAO.add(item);
    }

    public static void edit(int id, Item item) {
        _itemDAO.edit(id, item);
    }

    public static void delete(int id) {
        _itemDAO.delete(id);
    }

    public static List<Item> getAll() {
        return _itemDAO.getAll();
    }

    public static Item getItem(int id) {
        return _itemDAO.getItem(id);
    }
}

package com.itproger.tomcat;

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

    public static Item getField(int id) {
        return _itemDAO.getField(id);
    }

}

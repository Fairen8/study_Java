package Paid_Lessons.Modules.Module_4.les3;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            db.insertArticle("Новая статья", "Текст статьи", "2050-12-12", "Admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

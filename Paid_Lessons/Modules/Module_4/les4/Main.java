package Paid_Lessons.Modules.Module_4.les4;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            db.getArticles("articles");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

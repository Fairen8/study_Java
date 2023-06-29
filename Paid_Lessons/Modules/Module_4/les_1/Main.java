package Paid_Lessons.Modules.Module_4.les_1;

import Paid_Lessons.Modules.Module_4.DB; //Импортируем наш класс для работы с базой данных, т.к. они в разных папках

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();

        try {
            db.isConnected();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

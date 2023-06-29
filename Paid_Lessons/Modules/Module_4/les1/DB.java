package Paid_Lessons.Modules.Module_4.les1;

import java.sql.Connection; //Библиотека для подключения к базе данных
import java.sql.SQLException;
import java.sql.DriverManager; //Библиотека для подключения к базе данных

public class DB {
    //Класс для работы с базой данных MySQL

    //Поля для работы с базой данных
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

}

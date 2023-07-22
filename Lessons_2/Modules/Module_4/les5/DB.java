package Lessons_2.Modules.Module_4.les5;

import java.sql.*;


public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connstr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connstr, LOGIN, PASS);

        return dbConn;
    }


    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))"
                + " ENGINE=MYISAM;"; //Команда SQL для создания таблицы
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);

    }

    public void insertArticle(String title, String text,String date, String avtor) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `articles` (title, text, date, avtor) VALUES (?, ?, ?, ?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, text);
        prSt.setString(3, date);
        prSt.setString(4, avtor);

        prSt.executeUpdate();
    }

    public void updateArticles() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `articles` SET `title` = ? WHERE `id` = 2";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, "Новая обновлённая статья");

        prSt.executeUpdate();
    }

    public void deleteSome() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `articles` WHERE `id` = 4";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

}

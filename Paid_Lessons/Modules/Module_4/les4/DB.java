package Paid_Lessons.Modules.Module_4.les4;

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


    public void insertArticle(String title, String text,String date, String avtor) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `articles` (title, text, date, avtor) VALUES (?, ?, ?, ?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, text);
        prSt.setString(3, date);
        prSt.setString(4, avtor);

        prSt.executeUpdate();
    }

    public void getArticles(String table) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM " + table + " WHERE `text` LIKE '%New%' OR `id` = 1 ORDER BY `id` DESC LIMIT 1 OFFSET 2";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getInt("id"));
            System.out.println(res.getString("title"));
        }
    }

}

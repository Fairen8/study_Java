package Paid_Lessons.Homework.Module_4;

import java.sql.*;
import java.util.ArrayList;


public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "homework";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;
    private int item_id;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connstr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connstr, LOGIN, PASS);

        return dbConn;
    }

    public void setOrders() throws ClassNotFoundException, SQLException {
        Statement statement = getDbConnection().createStatement();

        ResultSet us_id = statement.executeQuery("SELECT id FROM `users` WHERE `login` = 'john'");
        us_id.next();
        int user_id = us_id.getInt("id");

        ResultSet items = statement.executeQuery("SELECT id FROM `items` WHERE `category` = 'hats'");
        ArrayList<Integer> item_ids = new ArrayList<>();
        while (items.next())
            item_ids.add(items.getInt("id"));

        statement.executeUpdate("ALTER TABLE `orders` ADD FOREIGN KEY(`user_id`) REFERENCES users(id)");
        statement.executeUpdate("ALTER TABLE `orders` ADD FOREIGN KEY(`item_id`) REFERENCES items(id)");

        for (Integer el : item_ids) {
            String sql = "INSERT INTO `orders`(`user_id`, `item_id`) VALUES (?, ?)";
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setInt(1, user_id);
            prSt.setInt(2, el);

            prSt.executeUpdate();
        }
    }

    public void getOrders() throws ClassNotFoundException, SQLException {
        String sql = "SELECT users.login, items.title FROM orders JOIN `users` ON users.id = user_id JOIN `items` ON items.id = item_id";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        System.out.println("Все заказы\n");
        while (res.next()) {
            System.out.println(res.getString("login") + " - " + res.getString("title"));
        }
    }


}

package com.example.module_10;

import java.sql.*;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_project";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    public ResultSet getArticle(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `title`, `text` FROM `articles` WHERE `id` = ?;";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setInt(1, id);


        return prSt.executeQuery();
    }

    public ResultSet getArticles() {
        String sql = "SELECT `id`, `title`, `intro` FROM `articles`;";
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void setUserParameters(int id, String login, String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `users` SET `login` = ?, `email` = ?, `password` = ? WHERE `id` = ?;";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, login);
        prSt.setString(2, email);
        prSt.setString(3, password);
        prSt.setInt(4, id);

        prSt.executeUpdate();
    }

    public int getUserid(String login) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `users` WHERE `login` = ?;";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);

        prSt.setString(1, login);

        ResultSet res = prSt.executeQuery();

        res.next();
        return res.getInt("id");
    }

    public String getUserEmail(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `email` FROM `users` WHERE `id` = ?;";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);

        prSt.setInt(1, id);

        ResultSet res = prSt.executeQuery();

        res.next();
        return res.getString("email");
    }

    public boolean authUser(String login, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `users` WHERE `login` = ? AND `password` = ?";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, login);
        prSt.setString(2, password);

        ResultSet res = prSt.executeQuery();
        return res.next();
    }

    public boolean isExistsUser(String login) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `users` WHERE `login` = ?";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, login);

        ResultSet res = prSt.executeQuery();

        return res.next();
    }

    public void regUser(String login, String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `users` (`login`, `email`, `password`) VALUES (?, ?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, login);
        prSt.setString(2, email);
        prSt.setString(3, password);

        prSt.executeUpdate();
    }

    public void addArticle(String title, String intro, String text) {
        String sql = "INSERT INTO `articles` (`title`, `intro`, `text`) VALUES (?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, title);
            prSt.setString(2, intro);
            prSt.setString(3, text);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

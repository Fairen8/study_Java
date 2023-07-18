package com.example.module_9;

import java.sql.*;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_project";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    public ResultSet getAricles() {
        String sql = "SELECT `title`, `intro` FROM `articles`;";
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
}

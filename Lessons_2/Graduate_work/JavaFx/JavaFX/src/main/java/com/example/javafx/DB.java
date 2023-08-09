package com.example.javafx;


import java.sql.*;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_diploma";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public ResultSet getLinks() {
        String sql = "SELECT * FROM `links`;";
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addlink(String full_link, String abbreviated_link) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `links` (`full`, `abbreviated`) VALUES (?, ?);";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, full_link);
        prSt.setString(2, abbreviated_link);

        prSt.executeUpdate();
    }

    public boolean isExistsLink(String abbreviated_link) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `links` WHERE `abbreviated` = ?;";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, abbreviated_link);

        ResultSet res = prSt.executeQuery();

        return res.next();
    }
}

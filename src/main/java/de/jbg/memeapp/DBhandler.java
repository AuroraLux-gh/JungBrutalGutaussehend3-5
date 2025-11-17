package de.jbg.memeapp;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;
import java.util.Optional;

public class DBhandler<T> {

    private String db = "memedb";
    private Integer currPic;

    //Konstruktor
    public DBhandler(String db) throws SQLException {
        this.db = db;
    }

    //SQL
    String sqlQuery1 = "SELECT * from memes";

    //establish connection
    Dotenv dotenv = Dotenv.load();
    String url = "jdbc:mariadb://localhost:3306/"+db;
    String user = Optional.ofNullable(dotenv.get("API_USER_DB")).orElseThrow(() -> new IllegalStateException("API_USER_DB env var is not defined"));
    String password = Optional.ofNullable(dotenv.get("API_KEY_DB")).orElseThrow(() -> new IllegalStateException("API_KEY_DB env var is not defined"));
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        System.out.println("Connection Established successfully");
    }

    //Query
    public void execQuery() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQuery1);
        while (result.next()) {
            System.out.println(result.getString("date"));
        }
    }


    //setter
    /*
        some setter to change the query
        some setter to change db
    */

    //getter
    public String getDB() {
        return this.db;
    }
    public Integer getCurrPic() {
        return this.currPic;
    }

}

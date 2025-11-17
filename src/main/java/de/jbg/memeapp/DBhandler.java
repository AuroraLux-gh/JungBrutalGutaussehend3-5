package de.jbg.memeapp;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Optional;

public class DBhandler {

    Dotenv dotenv = Dotenv.load();

    private String db = "memedb";
    private Integer currPic;

    //SQL
    String sqlQuery1 = "Select pic from memes where id=1";

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
    }

    //Konstruktor
    public DBhandler(String db) {
        this.db = db;
    }

    //setter


    //getter
    public String getDB() {
        return this.db;
    }
    public Integer getCurrPic() {
        return this.currPic;
    }

}

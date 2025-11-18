package de.jbg.memeapp;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;
import java.util.Optional;

public abstract class Query<destinationClass> {

    //Variables
    private String db;
    private Integer currPic;
    private Connection connection;
    private String sqlQuery;
    private String column;

    //Konstruktor
    public Query(String db) throws SQLException {
        this.db = db;

        //Session Setup
        Dotenv dotenv = Dotenv.load();
        String url = "jdbc:mariadb://localhost:3306/"+db;
        String user = Optional.ofNullable(dotenv.get("API_USER_DB")).orElseThrow(() -> new IllegalStateException("API_USER_DB env var is not defined"));
        String password = Optional.ofNullable(dotenv.get("API_KEY_DB")).orElseThrow(() -> new IllegalStateException("API_KEY_DB env var is not defined"));

        //establish Session
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established successfully");
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    //Query
    public void execQuery(String sqlQuery, String column) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQuery);
        while (result.next()) {
            System.out.println(result.getString(column));   //get String --> Ergebnis statt Objektpointer
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
    //(abstract, overwrite by extend classes)
    /*
    public abstract Integer getCurrPic();
    public abstract String getSqlQuery();
     */

}

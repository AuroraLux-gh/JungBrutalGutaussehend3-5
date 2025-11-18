package de.jbg.memeapp.category;

import de.jbg.memeapp.SessionInitiator;
import de.jbg.memeapp.category.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class CategoryQuery extends SessionInitiator {

    private Connection connection = getConnection();

    //Konstruktor
    public CategoryQuery() throws SQLException {
        super();
    }

    //Query
    String sqlQueryTag = "Select * FROM tag";

    public ArrayList<Category> execQuery() throws SQLException {
        ArrayList<Category> resultArray = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQueryTag);
        while (result.next()) {
            Category category = new Category();
            category.setCat_ID(result.getInt("cat_ID"));
            category.setCategory(result.getString("name"));

            //Fremdschlüssel bzw. sind auch NULL-Werte ok?, Attribute noch nicht definiert in Meme
            resultArray.add(category);
        }
        return resultArray;
    }

}

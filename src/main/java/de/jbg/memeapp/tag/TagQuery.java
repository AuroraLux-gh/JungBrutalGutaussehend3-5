package de.jbg.memeapp.tag;

import de.jbg.memeapp.SessionInitiator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class TagQuery extends SessionInitiator {

    private Connection connection = getConnection();

    //Konstruktor
    public TagQuery() throws SQLException {
        super();
    }

    //Query
    String sqlQueryTag = "Select * FROM tag";

    public ArrayList<Tag> execQuery() throws SQLException {
        ArrayList<Tag> resultArray = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlQueryTag);
        while (result.next()) {
            Tag tag = new Tag();
            tag.setTag_ID(result.getInt("tag_ID"));
            tag.setName(result.getString("name"));

            //Fremdschlüssel bzw. sind auch NULL-Werte ok?, Attribute noch nicht definiert in Meme
            resultArray.add(tag);
        }
        return resultArray;
    }

}

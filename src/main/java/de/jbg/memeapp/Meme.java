package de.jbg.memeapp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Meme extends Query<Meme> {

    public Meme(String db) throws SQLException {
        super("memedb");
    }

    /*
    //getter
    public String getQuery() {
        return this.query;          //aktuell in Query gesetzt
    }

    @Override
    Probleme wegen private, keine Lust jetzt noch reinzuschauen
    public Integer getCurrPic() {
        return this.currPic;
    }
    public String getSqlQuery() {
        return sqlQuery;
    }
     */

}
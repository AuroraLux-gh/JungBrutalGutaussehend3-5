package de.jbg.memeapp;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.jbg.memeapp.Memes.Meme;
import de.jbg.memeapp.Memes.MemeQuery;
import org.mariadb.jdbc.MariaDbBlob;

public class API {

    static class MyHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            //getID
            String requestURI = String.valueOf(String.valueOf(exchange.getRequestURI())); //double wrap as requested by IDE (wtf??)
            String[] parts = requestURI.split("/");
            String memeID = parts[parts.length-1];

            //getBlobOfOneMeme
            Blob response = new MariaDbBlob();   //API-Response
            String getSqlQuery = "Select * FROM memes";
            if (parts.length == 4) {
                getSqlQuery = "Select * FROM memes WHERE meme_ID=" + memeID;
            }
            try {
                MemeQuery memeQuery = new MemeQuery();
                ArrayList<Meme> memes = memeQuery.execGetQuery(getSqlQuery);

                for (Meme meme : memes) {
                    response = meme.getPic();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            //send response
            try {
                exchange.sendResponseHeaders(200, response.length());
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
            OutputStream outputStream = exchange.getResponseBody();
            try {
                outputStream.write(response.getBinaryStream().readAllBytes());
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
            outputStream.close();
        }
    }



}

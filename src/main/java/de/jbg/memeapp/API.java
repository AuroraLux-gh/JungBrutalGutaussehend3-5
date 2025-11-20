package de.jbg.memeapp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.jbg.memeapp.Memes.Meme;
import de.jbg.memeapp.Memes.MemeQuery;

public class API {

    String getSqlQuery = "Select * FROM memes";

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            //getAllMemeData
            StringBuilder response = new StringBuilder();   //API-Response
            String getSqlQuery = "Select * FROM memes";
            try {
                MemeQuery memeQuery = new MemeQuery();
                ArrayList<Meme> memes = memeQuery.execGetQuery(getSqlQuery);

                for (Meme meme : memes) {
                    response.append(meme.getMeme_ID()).append(" - ").append(meme.getPic()).append(" - ").append(meme.getDate());
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }


            //send response
            exchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.toString().getBytes());
            outputStream.close();
        }
    }



}

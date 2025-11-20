package de.jbg.memeapp;

import java.net.InetSocketAddress;
import java.sql.Date;
import java.time.LocalDate;

import com.sun.net.httpserver.HttpServer;
import de.jbg.memeapp.Memes.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //start API / Webserver (HTTP)

        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/api/memes", new API.MyHandler()); //this could be an abstract handler
            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



            //interact with Database
        //getData - Ausgabe in dieser Konsole
        String getSqlQuery = "Select * FROM memes";
        try {
            MemeQuery memeQuery = new MemeQuery();
            ArrayList<Meme> memes = memeQuery.execGetQuery(getSqlQuery);

            for (Meme meme : memes) {
                System.out.println(meme.getMeme_ID() + " - " + meme.getPic() + " - " + meme.getDate());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

                /* would need POST in the other project
        //setData
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("Bild.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //make input dynamic based on the file (https://github.com/haraldk/TwelveMonkeys)
        String setSqlQuery = "INSERT INTO memes (pic, date, height, length, size, category, tag) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            MemeQuery memeStatement = new MemeQuery();
            memeStatement.execInsertWithBlob(setSqlQuery,
                    inputStream,
                    Date.valueOf(LocalDate.now()),
                    100, 100, 32, 1, 1
            );
        } catch (Exception exception) {
            exception.printStackTrace();
        }
         */

    }
}
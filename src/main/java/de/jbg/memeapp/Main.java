package de.jbg.memeapp;


import de.jbg.memeapp.Memes.*;
import java.io.*;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Main {

    public static void main(String[] args) {

        //setPic
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("Bild.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String setSqlQuery = "INSERT INTO memes (pic, date, height, length, size, category, tag) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            MemeQuery memeStatement = new MemeQuery();
            memeStatement.execInsertWithBlob(setSqlQuery,
                    inputStream,
                    java.sql.Date.valueOf("2025-11-18"),
                    100, 100, 32, 1, 1
            );
        } catch (Exception exception) {
            exception.printStackTrace();
        }





        //getData
        try {
            MemeQuery memeQuery = new MemeQuery();
            ArrayList<Meme> memes = memeQuery.execGetQuery();

            for (Meme meme : memes) {
                System.out.println(meme.getMeme_ID() + " - " + meme.getPic() + " - " + meme.getDate());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
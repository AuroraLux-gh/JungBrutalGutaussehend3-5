package de.jbg.memeapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Main {

    public static void main(String[] args) {

        try {
            Meme memeStatement = new Meme("memedb");
            memeStatement.execQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
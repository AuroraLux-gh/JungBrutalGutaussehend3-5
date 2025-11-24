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
    }
}
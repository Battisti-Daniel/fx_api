package com.daniel.core.database;

import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private static Dotenv dotenv = Dotenv.load();

    private static String HOST = dotenv.get("DB_HOST");
    private static String PORT = dotenv.get("DB_PORT");
    private static String DB_NAME = dotenv.get("DB_NAME");
    private static String USER = dotenv.get("DB_USER");
    private static String PASSWORD = dotenv.get("DB_PASSWORD");

    private static final String URL = String.format(
        "jdbc:postgresql://%s:%s/%s",
         HOST, PORT, DB_NAME
        );

    public static Connection connect(){

        try {

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connectando ao banco de dados");

            return conn;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }


    }

    
}

package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostgreDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "newLVL111";

    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Connected to PostgreSQL!");
        } catch (SQLException e) {
            System.out.println(" Connection failed!"+e.getMessage());
            System.out.println(" Connection failed!"+e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        connect();
    }
}


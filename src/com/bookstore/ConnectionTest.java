package com.bookstore;

import java.sql.Connection;

public class ConnectionTest {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection()) {

            if (con != null) {
                System.out.println(
                    "MySQL connection successful!");
            } else {
                System.out.println(
                    "Connection failed. Check the error above.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
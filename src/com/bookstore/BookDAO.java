package com.bookstore;

import java.sql.*;

public class BookDAO {

    // CREATE
    public void insertBook(int id, String title,
                           String author, double price) {
        String sql = "INSERT INTO book VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);

            ps.executeUpdate();
            System.out.println("Book inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public void displayBooks() {
        String sql = "SELECT * FROM book";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nBook Records");
            System.out.println("------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("book_id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateBookPrice(int id, double price) {
        String sql = "UPDATE book SET price=? WHERE book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book updated successfully.");
            else
                System.out.println("Book not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBook(int id) {
        String sql = "DELETE FROM book WHERE book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book deleted successfully.");
            else
                System.out.println("Book not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
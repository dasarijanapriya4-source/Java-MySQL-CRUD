package com.bookstore;

public class Main {

    public static void main(String[] args) {

        BookDAO dao = new BookDAO();

        // CREATE
        dao.insertBook(3, "Python Programming",
                "Guido van Rossum", 600.00);

        // READ
        dao.displayBooks();

        // UPDATE
        dao.updateBookPrice(3, 650.00);

        // READ
        dao.displayBooks();

        // DELETE
        dao.deleteBook(3);

        // READ
        dao.displayBooks();
    }
}
package org.booktracker.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import org.booktracker.entity.Book;

public class BookDaoImpl implements BookDao {

    @Override
    public Collection<Book> getAllRecords() {

        Connection connection = null;
        PreparedStatement preparedStatement;

        Collection<Book> bookList = new ArrayList<Book>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookLibrary", "root", "password");

            preparedStatement = connection.prepareStatement("SELECT * FROM BOOKINFORMATION");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("BOOK_ID");
                String book_name = resultSet.getString("BOOK_NAME");
                String book_author = resultSet.getString("BOOK_AUTHOR");
                int num_copies = resultSet.getInt("NUM_COPIES");

                bookList.add(new Book(id, book_name, book_author, num_copies));
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();


            // CLOSES CONNECTION TO DATABASE
        } finally {
            try {

                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        // RETURNS COLLECTION OF BOOKS PULLED FROM DATABASE
        return bookList;
    }


    @Override
    public Book searchRecord(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement;

        Book book = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookLibrary", "root", "password");

            preparedStatement = connection.prepareStatement("SELECT * FROM BOOKINFORMATION WHERE BOOK_ID=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("BOOK_ID");
                String book_name = resultSet.getString("BOOK_NAME");
                String book_author = resultSet.getString("BOOK_AUTHOR");
                int num_copies = resultSet.getInt("NUM_COPIES");

                book = new Book(id, book_name, book_author, num_copies);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    @Override
    public int insertRecord(Book book) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        int rows = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookLibrary", "root", "password");

            preparedStatement = connection.prepareStatement("INSERT INTO BOOKINFORMATION VALUES(?,?,?,?)");

            preparedStatement.setInt(1, book.getBookId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getBookAuthor());
            preparedStatement.setInt(4, book.getNumCopies());


            rows = preparedStatement.executeUpdate();

            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }


    @Override
    public int deleteBook(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement;
        int rows = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookLibrary", "root", "password");

            preparedStatement = connection.prepareStatement("DELETE FROM BOOKINFORMATION WHERE BOOK_ID=?");

            preparedStatement.setInt(1, id);

            rows = preparedStatement.executeUpdate();

            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;

    }
}

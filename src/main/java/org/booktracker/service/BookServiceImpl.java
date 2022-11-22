package org.booktracker.service;

import java.util.Collection;

import org.booktracker.entity.Book;
import org.booktracker.persistence.BookDao;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    // ARGS CONSTRUCTOR USING DAO AS ARGUMENT
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookDao.getAllRecords();
    }

    @Override
    public Book searchBookById(int id) {
        return bookDao.searchRecord(id);
    }

    @Override
    public boolean addNewBook(Book book) {
        if (bookDao.insertRecord(book) > 0) {

            return true;

        } else {

            return false;
        }

    }


    @Override
    public boolean deleteBook(int id) {
        return bookDao.deleteBook(id) > 0;
    }

}

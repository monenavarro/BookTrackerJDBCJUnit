package org.booktracker.persistence;

import java.util.Collection;

import org.booktracker.entity.Book;


public interface BookDao {

    Collection<Book> getAllRecords();
    Book searchRecord(int id);
    int insertRecord(Book book);
    int deleteBook(int id);
}

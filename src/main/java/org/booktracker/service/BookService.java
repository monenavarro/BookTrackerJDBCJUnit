package org.booktracker.service;

import java.util.Collection;

import org.booktracker.entity.Book;

public interface BookService {

    Collection<Book> getAllBooks();

    Book searchBookById(int id);

    boolean addNewBook(Book book);

    boolean deleteBook(int bId);
}

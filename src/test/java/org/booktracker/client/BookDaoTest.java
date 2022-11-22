package org.booktracker.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.booktracker.entity.Book;
import org.booktracker.persistence.BookDaoImpl;

class BookDaoTest {

    BookDaoImpl bookDaoImpl;

    @BeforeEach
    void setUp() throws Exception {
        bookDaoImpl = new BookDaoImpl();
    }

    @AfterEach
    void tearDown() throws Exception {
        bookDaoImpl=null;
    }

    @Test
    void testGetAllRecords() {
        assertTrue(bookDaoImpl.getAllRecords().size()>0);
    }


    @Test
    void testInsertRecord() {
        assertEquals(1, bookDaoImpl.insertRecord(new Book(105,"The Lion, the Witch and the Wardrobe","C.S Lewis", 34000 )));
    }

    @Test
    void testDeleteRecord() {
        assertEquals(1, bookDaoImpl.deleteBook(101));
    }

    @Test
    void searchRecord() {assertNotNull(bookDaoImpl.searchRecord(104));
    }
}

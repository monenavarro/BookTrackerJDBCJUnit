package org.booktracker.client;

import org.booktracker.persistence.BookDaoImpl;
import org.booktracker.presentation.BookPresentationImpl;
import org.booktracker.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Bean(name="dao")
    public BookDaoImpl getPersistence() {
        return new BookDaoImpl();
    }

    @Bean(name="service")
    public BookServiceImpl getBookService() {
        //Constructor Injection
        return new BookServiceImpl(getPersistence());
    }

    @Bean(name="bookPresentation")
    public BookPresentationImpl getBookPresentation() {
        //Setter Injection
        BookPresentationImpl presentation=new BookPresentationImpl();
        presentation.setBookService(getBookService());
        return presentation;
    }
}

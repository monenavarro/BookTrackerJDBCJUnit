package org.booktracker.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.booktracker.presentation.BookPresentation;


public class BookSpringFramework  {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(BookConfiguration.class);

        BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bookPresentation");


        while(true) {

            bookPresentation.showMenu();
            System.out.println("Enter Your Selection: ");

            int userChoice = sc.nextInt();
            bookPresentation.performMenu(userChoice);
        }
    }
}

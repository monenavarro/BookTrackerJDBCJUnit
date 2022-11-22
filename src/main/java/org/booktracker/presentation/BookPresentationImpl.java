package org.booktracker.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.booktracker.entity.Book;
import org.booktracker.service.BookService;

public class BookPresentationImpl implements BookPresentation {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

        @Override
        public void showMenu() {
            System.out.println("===========================");
            System.out.println("Book Library System");
            System.out.println("1. List All Books");
            System.out.println("2. Search Book By ID");
            System.out.println("3. Add New Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.println("============================");

        }

        @Override
        public void performMenu(int choice) {
            Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case 1 -> {
                    Collection<Book> books = bookService.getAllBooks();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                }
                case 2 -> {
                    System.out.println("Enter Book ID : ");
                    int id = scanner.nextInt();
                    Book book = bookService.searchBookById(id);
                    if (book != null)
                        System.out.println(book);
                    else
                        System.out.println("Book with id " + id + " does not exist!");
                }
                case 3 -> {
                    Book newBook = new Book();
                    System.out.println("Enter Book id : ");
                    newBook.setBookId(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Enter Book Name : ");
                    newBook.setBookName(scanner.nextLine());
                    System.out.println("Enter Book Author : ");
                    newBook.setBookAuthor(scanner.nextLine());
                    System.out.println("Enter Number of Copies : ");
                    newBook.setNumCopies(scanner.nextInt());

                    if (bookService.addNewBook(newBook))
                        System.out.println("Book Record Added");
                    else
                        System.out.println("Book with id " + newBook.getBookId() + " already exists, so cannot add it as a new book!");
                }
                case 4 -> {
                    System.out.println("Enter Book ID : ");
                    int bId = scanner.nextInt();
                    if (bookService.deleteBook(bId))
                        System.out.println("Book with id " + bId + " deleted");
                    else
                        System.out.println("Book with id " + bId + " does not exist");
                }
                case 5 -> {
                    System.out.println("Thanks for using the best Book Library System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice!");
            }

        }
    }






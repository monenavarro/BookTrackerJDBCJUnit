package org.booktracker.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int numCopies;


}

package com.librarymanagement;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    // Constructor
    public Book(String bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    public String getBookId()
   {
     return bookId;
   }
    public String getTitle() 
   { 
     return title; 
   }
    public String getAuthor()
   { 
     return author;
   }
    public String getGenre()
   {
    return genre; 
   }      
}
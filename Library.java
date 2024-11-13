// user defined package
package com.librarymangement;
//import packages
import java.io.*;
import java.util.*;

public class Library 
{
    private Map<String, Book> books;
    private Map<String, Member> members;
    
    // Constructor
    public Library() 
    {
        books = new HashMap<>();
        members = new HashMap<>();
        loadBooksFromFile();
        loadMembersFromFile();
    }

    // Adding book to the library
    public void addBook(Book book)
    {
        books.put(book.getBookId(), book);
    }

    // Register a new member
    public void registerMember(Member member)
    {
        members.put(member.getMemberId(), member);
    }

    // Borrow a book
    public boolean borrowBook(String memberId, String bookId) 
    {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book != null && member != null && book.isAvailable()) 
        {
            book.setAvailable(false);
            member.borrowBook(book);
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(String memberId, String bookId) 
    {
        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (book != null && member != null && member.getBorrowedBooks().contains(book)) 
        {
            book.setAvailable(true);
            member.returnBook(book);
            return true;
        }
        return false;
    }

    // List all books and their availability status
    public void listAllBooks() 
    {
        System.out.println("List of Books:");
        for (Book book : books.values())
        {
            System.out.println("ID: " + book.getBookId() + ", Title: " + book.getTitle() +
                    ", Available: " + book.isAvailable());
        }
    }

    // List all members
    public void listAllMembers()
    {
        System.out.println("List of Members:");
        for (Member member : members.values()) {
            System.out.println("ID: " + member.getMemberId() + ", Name: " + member.getName());
        }
    }

    // Saves the current list of books in the library to a file.
    public void saveBooksToFile()
         //FileWriter to open the file for writing data 
        //BufferedWritter will make it more efficient for writing large files
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/books.txt"))) 
        {
            for (Book book : books.values()) 
            {
                writer.write(book.getBookId() + "," + book.getTitle() + "," +
                        book.getAuthor() + "," + book.getGenre() + "," + book.isAvailable());
                writer.newLine();
            }
        } 
        catch (IOException e) // Try and Catch Block for Exception Handling
        {
            System.out.println("Error saving books to file.");
        }
    }

    // Saves the current list of members in the library to a file
    public void saveMembersToFile() 
    {
        //FileWriter to open the file for writing data 
        //BufferedWritter will make it more efficient for writing large files
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/members.txt")))
        {
            for (Member member : members.values()) 
            {
                writer.write(member.getMemberId() + "," + member.getName() + "," + member.getEmail());
                for (Book book : member.getBorrowedBooks()) 
                {
                    writer.write("," + book.getBookId());
                }
                writer.newLine();
            }
        } 
        catch (IOException e) // Try and Catch Block for Exception Handling
        {
            System.out.println("Error saving members to file.");
        }
    }

    //Loads books data from a file 
    public void loadBooksFromFile() 
    {
        //BufferedReader is used to read text from an input file
       //FileReader is used to open the file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/books.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                String bookId = parts[0];
                String title = parts[1];
                String author = parts[2];
                String genre = parts[3];
                boolean isAvailable = Boolean.parseBoolean(parts[4]);
                Book book = new Book(bookId, title, author, genre);
                book.setAvailable(isAvailable);
                books.put(bookId, book);
            }
        } 
        catch (IOException e) // Try and Catch Block for Exception Handling
        {
            System.out.println("Error loading books from file.");
        }
    }

    // Load members data from file
    public void loadMembersFromFile() 
    {
        //BufferedReader is used to read text from an input file
       //FileReader is used to open the file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/members.txt"))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                String memberId = parts[0];
                String name = parts[1];
                String email = parts[2];

                Member member = new Member(memberId, name, email);

                for (int i = 3; i < parts.length; i++) 
                {
                    Book borrowedBook = books.get(parts[i]);
                    if (borrowedBook != null) 
                    {
                        member.borrowBook(borrowedBook);
                        borrowedBook.setAvailable(false);  // Mark as borrowed
                    }
                }

                members.put(memberId, member);
            }
        } 
        catch (IOException e) //Try and Catch Block for Exception Handling
        {
            System.out.println("Error loading members from file.");
        }
    }
}

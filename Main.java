package com.librarymangement; // user defined package

import java.util.Scanner;  // importing Scanner class

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();    // creating object for library class
       
        while (true) 
        {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. AddBook");
            System.out.println("2. RegisterMember");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. List all books");
            System.out.println("6. List all members");
            System.out.println("7. Exit");
           
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
               // for adding a new book
                case 1:
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter book Name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter Author name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String bookGenre = scanner.nextLine();
                    
                   // try and catch block for exception handling 
                    try 
                    {
                        library.addBook(new Book(bookId, bookName, authorName, bookGenre));
                        System.out.println("Book added successfully.");
                        library.saveBooksToFile();
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Failed to add the book.");
                    }
                    
                    library.listAllBooks();
                    break;
                // for registering a new member
                case 2:
                    System.out.print("Enter member ID: ");
                    String memId = scanner.nextLine();
                    System.out.print("Enter member Name: ");
                    String memName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    
                    try 
                    {
                        library.registerMember(new Member(memId, memName, email));
                        System.out.println("Member registered successfully.");
                        library.saveMembersToFile();
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Failed to register member.");
                    }
                    
                    library.listAllMembers();
                    break;
                // for borrowing a book
                case 3:
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookIdBorrow = scanner.nextLine();
                    
                    if (library.borrowBook(memberId, bookIdBorrow))
                    {
                        System.out.println("Book borrowed successfully.");
                        library.saveBooksToFile();
                        library.saveMembersToFile();
                    } 
                    else 
                    {
                        System.out.println("Failed to borrow the book.");
                    }
                    break;
                // for returning a book
                case 4:
                    System.out.print("Enter member ID: ");
                    String memberIdReturn = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookIdReturn = scanner.nextLine();
                    
                    if (library.returnBook(memberIdReturn, bookIdReturn))
                    {
                        System.out.println("Book returned successfully.");
                        library.saveBooksToFile();
                        library.saveMembersToFile();
                    } 
                    else 
                    {
                        System.out.println("Failed to return the book.");
                    }
                    break;

                case 5:
                    library.listAllBooks(); // calling lisAllBooks method from library class to show all books
                    break;

                case 6:
                    library.listAllMembers(); // calling lisAllMembers method from library class to show all members
                    break;

                case 7:
                    library.saveBooksToFile();
                    library.saveMembersToFile();
                    System.out.println("Exiting program. Data saved.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and7.");
                    break;
            }
        }
    }
}

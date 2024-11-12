package com.librarymanagement;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
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
            
        }
    }
}


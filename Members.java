package com.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Member
{
    private String memberId;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public Member(String memberId, String name, String email) // constractor
    {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter Methods
    public String getMemberId()
    { return memberId;
    }
    public String getName() 
    { return name; 
    }
    public String getEmail() 
    { return email;
    }
    public List<Book> getBorrowedBooks() 
    { 
    	
    	return borrowedBooks;
    }

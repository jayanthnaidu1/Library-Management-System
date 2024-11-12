package com.librarymanagement;
import java.io.*;
import java.util.*;
public class Library 
{
    private Map<String, Book> books;
    private Map<String, Member> members;

    public Library() 
    {
        books = new HashMap<>();
        members = new HashMap<>();
    }
}

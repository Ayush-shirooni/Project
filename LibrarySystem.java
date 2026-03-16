package com.library.main;

import com.library.books.Book;
import com.library.books.BookManager;
import com.library.users.User;
import com.library.transactions.TransactionManager;

public class LibrarySystem {
    public static void main(String[] args) {
        System.out.println("=== Initializing Library Management System ===");

        // Initialize Managers
        BookManager bookManager = new BookManager();
        TransactionManager transactionManager = new TransactionManager(bookManager);

        // Create Users
        User user1 = new User("U01", "Alice");
        User user2 = new User("U02", "Bob");

        // 1. Store and manage information about books
        bookManager.addBook(new Book("B01", "Effective Java", "Joshua Bloch"));
        bookManager.addBook(new Book("B02", "Clean Code", "Robert C. Martin"));
        bookManager.addBook(new Book("B03", "Design Patterns", "Gang of Four"));

        // 3. Display available books in the library
        bookManager.displayAvailableBooks();

        // 2. Allow borrowing and returning books
        System.out.println(">> Borrowing Books");
        transactionManager.borrowBook("B01", user1); // Alice borrows Effective Java
        transactionManager.borrowBook("B01", user2); // Bob tries to borrow Effective Java (should fail)
        transactionManager.borrowBook("B02", user2); // Bob borrows Clean Code

        // Display available books after borrowing
        bookManager.displayAvailableBooks();

        System.out.println(">> Returning Books");
        transactionManager.returnBook("B01", user1); // Alice returns Effective Java

        // Display available books after returning
        bookManager.displayAvailableBooks();
    }
}


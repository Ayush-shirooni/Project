package com.library.transactions;

import com.library.books.Book;
import com.library.books.BookManager;
import com.library.users.User;

public class TransactionManager {
    private BookManager bookManager;

    public TransactionManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    public void borrowBook(String bookId, User user) {
        Book book = bookManager.findBookById(bookId);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Transaction: User '" + user.getName() + "' successfully borrowed '" + book.getTitle() + "'.");
            } else {
                System.out.println("Transaction Failed: The book '" + book.getTitle() + "' is currently not available.");
            }
        } else {
            System.out.println("Transaction Failed: Book with ID " + bookId + " not found.");
        }
    }

    public void returnBook(String bookId, User user) {
        Book book = bookManager.findBookById(bookId);
        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Transaction: User '" + user.getName() + "' successfully returned '" + book.getTitle() + "'.");
            } else {
                System.out.println("Transaction Failed: The book '" + book.getTitle() + "' was not borrowed.");
            }
        } else {
            System.out.println("Transaction Failed: Book with ID " + bookId + " not found.");
        }
    }
}


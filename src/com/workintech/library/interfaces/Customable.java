package com.workintech.library.interfaces;

import com.workintech.library.books.Book;
import com.workintech.library.books.enums.BookStatus;

import java.util.List;

public interface Customable {
    void addBook(List<Book> list, Book book);
    void deleteBook(List<Book> list, Book book);
    void updateBook(List<Book> list, Book book, double price);
    void updateBook(List<Book> list, Book book, BookStatus status);
}

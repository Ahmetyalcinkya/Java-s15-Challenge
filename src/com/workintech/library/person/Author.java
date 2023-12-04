package com.workintech.library.person;

import com.workintech.library.books.Book;
import com.workintech.library.books.enums.BookStatus;
import com.workintech.library.interfaces.Customable;
import com.workintech.library.person.enums.Role;

import java.util.ArrayList;
import java.util.List;

public final class Author extends Person implements Customable {
    String password;

    public Author(long id, String name, String surname, String password) {
        super(id, name, surname, Role.AUTHOR);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void addBook(List<Book> list, Book book) {
        if (list.contains(book)){
            System.out.println("This book already in this library.");
        }else {
            list.add(book);
            System.out.println("Author add the book to library. Added Book: " + book);
        }
    }
    @Override
    public void deleteBook(List<Book> list, Book book) {
        if (list.contains(book)){
            list.remove(book);
            System.out.println("Author delete the book from library. Deleted Book : " + book);
        }else {
            System.out.println("You cannot delete the book that doesn't exist.");
        }
    }
    @Override
    public void updateBook(List<Book> list, Book book, double price) {
        if(list.contains(book)){
            book.setPrice(price);
        }else {
            System.out.println("Yout cannot change the price value. The book doesn't exist.");
        }
    }
    @Override
    public void updateBook(List<Book> list, Book book, BookStatus status) {
        if(list.contains(book)){
            book.setStatus(status);
        }else {
            System.out.println("Yout cannot change the status. The book doesn't exist.");
        }
    }
}

package com.workintech.library;

import com.workintech.library.books.Book;
import com.workintech.library.person.Author;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Reader;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {

    private List<Book> books;
    private Set<Reader> readers;
    private Set<Author> authors;

    private Map<Book, Reader> borrowedBooks;
    private List<Book> returnedBooks;
    private Librarian librarian;
    private double libraryBalance;

    public Library(List<Book> books, Set<Reader> readers,Set<Author> authors, Map<Book, Reader> borrowedBooks, List<Book> returnedBooks, Librarian librarian) {
        this.books = books;
        this.readers = readers;
        this.authors = authors;
        this.borrowedBooks = borrowedBooks;
        this.returnedBooks = returnedBooks;
        this.librarian = librarian;
        this.libraryBalance = 0;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Map<Book, Reader> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<Book, Reader> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getReturnedBooks() {
        return returnedBooks;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public double getLibraryBalance() {
        return libraryBalance;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                ", borrowedBooks=" + borrowedBooks +
                ", returnedBooks=" + returnedBooks +
                ", librarian=" + librarian +
                '}';
    }
}

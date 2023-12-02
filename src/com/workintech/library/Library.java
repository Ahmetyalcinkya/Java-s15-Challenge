package com.workintech.library;

import com.workintech.library.books.Book;
import com.workintech.library.person.Librarian;
import com.workintech.library.person.Reader;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {

    private List<Book> books;
    private Set<Reader> readers;
    private Map<Book, Reader> borrowedBooks;
    private List<Book> returnedBooks;
    private Librarian librarian;

    public Library(List<Book> books, Set<Reader> readers, Map<Book, Reader> borrowedBooks, List<Book> returnedBooks, Librarian librarian) {
        this.books = books;
        this.readers = readers;
        this.borrowedBooks = borrowedBooks;
        this.returnedBooks = returnedBooks;
        this.librarian = librarian;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
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

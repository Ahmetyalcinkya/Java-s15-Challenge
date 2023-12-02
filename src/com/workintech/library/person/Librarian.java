package com.workintech.library.person;

import com.workintech.library.books.Book;
import com.workintech.library.books.enums.BookStatus;
import com.workintech.library.person.enums.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Librarian extends Person {
    private String password;

    public Librarian(long id, String name, String surname, String password) {
        super(id, name, surname, Role.ADMIN);
        this.password = password;
    }

    public void putReturnedBooksToLibrary(List<Book> list, Book book){
        if (list.contains(book)){
            System.out.println("This book already in the library.");
        }else {
            list.add(book);
            System.out.println("The book has returned to its place in the library.");
        }
    }

    public Book findBookByName(List<Book> list, String bookTitle){
        for(Book book : list){
            String bookName = book.getTitle();
            if(bookName.contains(bookTitle)){
                System.out.println("The book has found. Book: " + book);
                return book;
            }else {
                System.out.println("We didn't find the book that you searched.");
            }
        }
        return null;
    }
    public Book findBookByID(List<Book> list, long bookID){
        for(Book book: list){
            long id = book.getId();
            if(id == bookID){
                System.out.println("The book has found. Book: " + book);
                return book;
            }else{
                System.out.println("We didn't find the book that you searched.");

            }
        }
        return null;
    }
    public void addBook(List<Book> list, Book book){
        if (list.contains(book)){
            System.out.println("This book already in this library.");
        }else {
            list.add(book);
            System.out.println("Librarian add the book to library. Added Book: " + book);
        }
    }
    public void deleteBook(List<Book> list, Book book){
        if (list.contains(book)){
            list.remove(book);
            System.out.println("Librarian delete the book from library. Deleted Book : " + book);
        }else {
            System.out.println("You cannot delete the book that doesn't exist.");
        }
    }
    public void updateBook(List<Book> list, Book book, int price){
        if(list.contains(book)){
            book.setPrice(price);
        }else {
            System.out.println("Yout cannot change the price value. The book doesn't exist.");
        }
    }
    public void updateBook(List<Book> list, Book book, BookStatus status){
        if(list.contains(book)){
            book.setStatus(status);
        }else {
            System.out.println("Yout cannot change the status. The book doesn't exist.");
        }
    }
    public void borrowBook(List<Book> list, Map<Book, Reader> borrow, Reader reader, Book book){
        if (list.contains(book) && reader.getLimit() > 0){
            reader.getBorrowed().add(book);
            borrow.put(book,reader);
            reader.setLimit(reader.getLimit() -1);
            System.out.println(book.getTitle() + " has borrowed to " + reader.getName());
        } else {
            System.out.println("This book already borrowed.");
        }
    } // NULL DÖNÜYOR!!!!


}

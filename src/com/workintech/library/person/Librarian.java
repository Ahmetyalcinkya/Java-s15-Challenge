package com.workintech.library.person;

import com.workintech.library.Library;
import com.workintech.library.books.Book;
import com.workintech.library.books.enums.BookStatus;
import com.workintech.library.interfaces.Customable;
import com.workintech.library.person.enums.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Librarian extends Person implements Customable {
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
    public void updateBook(List<Book> list, Book book, double price){
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
    public void feeReceived(Book book, Reader reader){
        reader.setPayment(book.getPrice());
        System.out.println("Borcunuz : " + book.getPrice());
    }
    public void refundedFee(Library library,Map<Book, Reader> borrow, Book book, Reader reader){
        if(borrow.containsKey(book)){
            System.out.println("Status on the date of receipt: " + book.getStatus());
            BookStatus updatedStatus = book.setStatus(BookStatus.randomStatus());
            System.out.println("updatedstatus = " + updatedStatus);

            if(updatedStatus.equals(BookStatus.UNDAMAGED)){
                reader.setBalance(reader.getPayment());
                reader.setLimit(reader.getLimit() + 1);
                System.out.println(reader.getName() + "'s balance: " + reader.getBalance());

            } else if (updatedStatus.equals(BookStatus.SLIGHTLYDAMAGED)) {
                reader.setBalance(reader.getPayment() - ((reader.getPayment() / 3) * 2));
                double balance = library.getLibraryBalance();
                balance += ((reader.getPayment() / 3) * 2);
                reader.setLimit(reader.getLimit() + 1);
                System.out.println("Library's balance: " + balance);
                System.out.println(reader.getName() + "'s balance: " + reader.getBalance());

            }else if (updatedStatus.equals(BookStatus.DAMAGED)) {
                reader.setBalance(reader.getPayment() - ((reader.getPayment() / 3) * 1));
                double balance = library.getLibraryBalance();
                balance += ((reader.getPayment() / 3) * 1);
                System.out.println("Library's balance: " + balance);
                System.out.println(reader.getName() + "'s balance: " + reader.getBalance());

            }else if (updatedStatus.equals(BookStatus.UNUSABLE)) {
                reader.setBalance(0);
                double balance = library.getLibraryBalance();
                balance += (reader.getPayment());
                System.out.println("Library's balance: " + balance);
                System.out.println(reader.getName() + "'s balance: " + reader.getBalance());
            }
        }else {
            System.out.println("This book is not an element of this library.");
        }

    }
    public Reader findReader(Set<Reader> readerList, String readerName) {
        for (Reader reader : readerList) {
            String readersName = reader.getName();
            if (readersName.contains(readerName)) {
                System.out.println("The reader has found. Reader: " + reader);
                return reader;
            } else {
                System.out.println("We didn't find the reader that you searched.");
            }
        }
        return null;
    }
    public Author findAuthor(Set<Author> authorList, String authorName){
        for (Author author : authorList) {
            String authorsName = author.getName();
            if (authorsName.contains(authorName)) {
                System.out.println("The author has found. Author: " + author);
                return author;
            } else {
                System.out.println("We didn't find the author that you searched.");
            }
        }
        return null;
    }
}

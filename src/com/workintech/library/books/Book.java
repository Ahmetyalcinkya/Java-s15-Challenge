package com.workintech.library.books;

import com.workintech.library.books.enums.BookStatus;
import com.workintech.library.books.enums.BookType;

public class Book {
    private long id;
    private String title;
    private String author;
    private int stock;
    private BookStatus status;
    private BookType type;
    private double price;

    public Book(long id, String title, String author, int stock, BookStatus status, BookType type, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.status = status;
        this.type = type;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", stock=" + stock +
                ", status=" + status +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}

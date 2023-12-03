package com.workintech.library.person;

import com.workintech.library.books.Book;
import com.workintech.library.person.enums.Role;

import java.util.Set;

public class Reader extends Person {

    private int limit;
    private Set<Book> borrowed;
    private double payment;
    private double balance;
    public Reader(long id, String name, String surname) {
        super(id, name, surname, Role.USER);
        this.limit = 5;
    }

    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Set<Book> getBorrowed() {
        return borrowed;
    }
    public void setBorrowed(Set<Book> borrowed) {
        this.borrowed = borrowed;
    }

    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

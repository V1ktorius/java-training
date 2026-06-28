package ru.aston.hometask2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Book> books;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public List<Book> getBooks() {
        return books;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public Student setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public Student addBook(Book book) {
        books.add(book);
        return this;
    }

    public String getBooksNames() {
        return String.join("; ", books.stream().map(Book::toString).toList());
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}

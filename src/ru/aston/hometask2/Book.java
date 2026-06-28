package ru.aston.hometask2;

public final class Book {
    private final String name;
    private final String author;
    private final int pageCount;
    private final int yearPublished;

    public Book(String name, String author, int pageCount, int yearPublished) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public int getPageCount() {
        return pageCount;
    }
    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return name;
    }
}

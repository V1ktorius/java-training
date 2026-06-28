package ru.aston.hometask2;

import java.util.Comparator;
import java.util.List;

public class StudentService {
    public static void streamStudentsIntoConsole(List<Student> students) {
        students.stream()
                .peek(System.out::println)
                .peek(student -> System.out.println(student.getBooksNames()))
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .peek(book -> System.out.println("Sorted " + book + " " + book.getYearPublished() + " " + book.getPageCount()))
                .distinct()
                .peek(book -> System.out.println("Distinct " + book + " " + book.getYearPublished() + " " + book.getPageCount()))
                .filter(book -> book.getYearPublished() > 2000)
                .peek(book -> System.out.println("Filtered " + book + " " + book.getYearPublished() + " " + book.getPageCount()))
                .limit(3)
                .peek(book -> System.out.println("Limit3 " + book + " " + book.getYearPublished() + " " + book.getPageCount()))
                .map(Book::getYearPublished)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Книга не найдена"))
        ;
    }
}

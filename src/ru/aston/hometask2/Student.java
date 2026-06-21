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
    //location of example file for testing purposes: "src/ru/aston/hometask2/students.json"
    final public static String STUDENTS_JSON_FILE_PATH = "STUDENTS_JSON_FILE_PATH";

    final private static String JSON_FIRST_NAME = "firstName";
    final private static String JSON_LAST_NAME = "lastName";
    final private static String JSON_LIBRARY = "library";
    final private static String JSON_NAME = "name";
    final private static String JSON_AUTHOR = "author";
    final private static String JSON_YEAR = "year";
    final private static String JSON_PAGES = "pages";

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

    public static List<Student> getStudentsFromJsonFile(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = new ArrayList<>();

        try {
            Iterator<JsonNode> array = mapper.readTree(new File(filePath)).elements();
            JsonNode studentNode, bookNode;
            Student student;
            while (array.hasNext()) {
                studentNode = array.next();
                if (!(studentNode.has(JSON_FIRST_NAME) && studentNode.get(JSON_FIRST_NAME).isTextual()) ||
                        !(studentNode.has(JSON_LAST_NAME) && studentNode.get(JSON_LAST_NAME).isTextual()) ||
                        !(studentNode.has(JSON_LIBRARY) && studentNode.get(JSON_LIBRARY).isArray())) {
                    continue;
                }
                student = new Student(studentNode.get(JSON_FIRST_NAME).asText(), studentNode.get(JSON_LAST_NAME).asText());
                Iterator<JsonNode> library = studentNode.get(JSON_LIBRARY).elements();
                while (library.hasNext()) {
                    bookNode = library.next();
                    if ((bookNode.has(JSON_NAME) && bookNode.get(JSON_NAME).isTextual()) &&
                            (bookNode.has(JSON_AUTHOR) && bookNode.get(JSON_AUTHOR).isTextual()) &&
                            (bookNode.has(JSON_PAGES) && bookNode.get(JSON_PAGES).isInt()) &&
                            (bookNode.has(JSON_YEAR) && bookNode.get(JSON_YEAR).isInt())) {
                        student.addBook(new Book(bookNode.get(JSON_NAME).asText(), bookNode.get(JSON_AUTHOR).asText(),
                                bookNode.get(JSON_PAGES).asInt(), bookNode.get(JSON_YEAR).asInt()));
                    }
                }
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }

        return students;
    }

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

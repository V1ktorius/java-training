package ru.aston.hometask2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Start {
    public static void main(String[] args) {
        String filePath = "src/ru/aston/hometask2/students.json";

        List<Student> students = readFromJsonFile(filePath);

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

    private static List<Student> readFromJsonFile(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = new ArrayList<>();

        try {
            Iterator<JsonNode> array = mapper.readTree(new File(filePath)).elements();
            JsonNode studentNode, bookNode;
            Student student;
            while (array.hasNext()) {
                studentNode = array.next();
                if (!(studentNode.has("firstName") && studentNode.get("firstName").isTextual()) ||
                        !(studentNode.has("lastName") && studentNode.get("lastName").isTextual()) ||
                        !(studentNode.has("library") && studentNode.get("library").isArray())) {
                    continue;
                }
                student = new Student(studentNode.get("firstName").asText(), studentNode.get("lastName").asText());
                Iterator<JsonNode> library = studentNode.get("library").elements();
                while (library.hasNext()) {
                    bookNode = library.next();
                    if (!(bookNode.has("name") && bookNode.get("name").isTextual()) ||
                            !(bookNode.has("author") && bookNode.get("author").isTextual()) ||
                            !(bookNode.has("year") && bookNode.get("year").isInt()) ||
                            !(bookNode.has("pages") && bookNode.get("pages").isInt())) {
                        continue;
                    }
                    student.addBook(new Book(bookNode.get("name").asText(), bookNode.get("author").asText(), bookNode.get("pages").asInt(), bookNode.get("year").asInt()));
                }
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error message: " + e.getMessage());
        }

        return students;
    }
}

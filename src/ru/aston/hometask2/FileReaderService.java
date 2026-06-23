package ru.aston.hometask2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReaderService {
    //location of example file for testing purposes: "src/ru/aston/hometask2/students.json"
    final public static String STUDENTS_JSON_FILE_PATH = "STUDENTS_JSON_FILE_PATH";

    final private static String JSON_FIRST_NAME = "firstName";
    final private static String JSON_LAST_NAME = "lastName";
    final private static String JSON_LIBRARY = "library";
    final private static String JSON_NAME = "name";
    final private static String JSON_AUTHOR = "author";
    final private static String JSON_YEAR = "year";
    final private static String JSON_PAGES = "pages";

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
}

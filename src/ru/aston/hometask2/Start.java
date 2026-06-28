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
        String filePath = System.getenv(FileReaderService.STUDENTS_JSON_FILE_PATH);

        List<Student> students = FileReaderService.getStudentsFromJsonFile(filePath);

        StudentService.streamStudentsIntoConsole(students);
    }
}

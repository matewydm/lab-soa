package pl.edu.agh.kis.soa;


import pl.edu.agh.kis.soa.generated.Course;
import pl.edu.agh.kis.soa.generated.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SoapConsumer {

    public static void main(String[] args) {
        StudentConsumer studentConsumer = new StudentConsumer();
        DeanPrinter deanPrinter = new DeanPrinter();

        Student student = studentConsumer.getStudentByIndex("275789");
        deanPrinter.printStudent(student);

        List<String> indexes = new ArrayList<>();
        indexes.add("275789");
        indexes.add("275757");
        List<Student> studentList = studentConsumer.getStudentsByIndexes(indexes);
        deanPrinter.printStudents(studentList);

        String encoded = studentConsumer.setPicture("275789","/home/mucha/Obrazy/wallpaper.jpg");

        FileConsumer fileConsumer = new FileConsumer();
        String encodedFile = fileConsumer.sendFile("/home/mucha/Obrazy/wallpaper.jpg");
    }

}

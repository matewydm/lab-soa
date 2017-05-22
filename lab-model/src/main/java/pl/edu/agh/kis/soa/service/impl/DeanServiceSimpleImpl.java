package pl.edu.agh.kis.soa.service.impl;

import pl.edu.agh.kis.soa.model.json.Course;
import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.service.DeanService;
import pl.edu.agh.kis.soa.service.MockDean;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@MockDean
public class DeanServiceSimpleImpl implements DeanService{

    private List<Student> studentList = new ArrayList<>();

    @Override
    public Student findStudent(String index) {
        for (Student s : studentList) {
            if (s.getIndexNumber().equals(index)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentList;
    }

    @Override
    public List<Student> getStudentsByIndexList(List<String> indexList) {
        List<Student> retStudents = new ArrayList<>();
        for (Student student : studentList) {
            for (String index: indexList) {
                if (index.equals(student.getIndexNumber())){
                    retStudents.add(student);
                }
            }
        }

        return retStudents;
    }

    @Override
    public byte[] getStudentPicture(String index) {
        for (Student student : studentList) {
            if (student.getIndexNumber().equals(index)){
                return student.getPicture();
            }
        }

        return null;
    }

    @Override
    public String setStudentPicture(String index, byte[] file) {
        String encoded = null;
        for (Student student : studentList) {
            if (student.getIndexNumber().equals(index)){
                student.setPicture(file);
                encoded = Base64.getEncoder().encodeToString(file);
            }
        }

        return encoded;
    }

    @Override
    public void deleteStudent(String index) {
        studentList.stream().filter(student -> !student.getIndexNumber().equals(index));
    }

    @Override
    public void updateStudent(Student studentParam) {
        for (Student student : studentList) {
            if (student.getIndexNumber().equals(studentParam)){
                studentList.remove(student);
                studentList.add(studentParam);
            }
        }
    }

    @Override
    public String findStudentName(String index) {
        Optional<Student> foundStudent = studentList.stream().filter(student -> student.getIndexNumber().equals(index)).findFirst();
        return foundStudent.get().getFirstName();
    }

    private byte[] getFileByPath(String path) {
        File file = new File(path);
        byte[] byteArray = new byte[(int) file.length()];
        try {
            byteArray = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    @PostConstruct
    private void initStudents() {
        List studentList = new ArrayList<Student>();

        Student s1 = new Student("Mateusz", "Wydmanski", "275789", getFileByPath("/home/mucha/Obrazy/wallpaper.jpg" ), Arrays.asList(
                new Course[] {new Course("SOA", 5)}
        ));
        Student s2 = new Student("Michał", "Kałduś", "275757",  getFileByPath("/home/mucha/Obrazy/chrome-icon.png" ),  Arrays.asList(
                new Course[] {new Course("SOA", 5)}
        ));
        studentList.add(s1);
        studentList.add(s2);

        List<Student> studentBuilderList = new ArrayList<Student>();
        Student x1 = new Student.Builder().firstName("Marcin").surname("Flis").indexNumber("275213").courses(new
                Course.Builder().name("SOA").ects(5).build()).courses(new Course.Builder().name("SW").ects(3).build()).build();
        Student x2 = new Student.Builder().firstName("Damian").surname("Pasek").indexNumber("275212").courses(new
                Course.Builder().name("SOA").ects(5).build()).courses(new Course.Builder().name("SW").ects(3).build()).build();
        studentBuilderList.add(x1);
        studentBuilderList.add(x2);

        this.studentList.addAll(studentList);
        this.studentList.addAll(studentBuilderList);
    }
}

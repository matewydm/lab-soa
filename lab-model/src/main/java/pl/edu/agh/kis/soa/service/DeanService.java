package pl.edu.agh.kis.soa.service;

import pl.edu.agh.kis.soa.model.json.Student;

import java.util.List;

public interface DeanService {

    Student findStudent(String index);

    List<Student> getAllStudent();

    List<Student> getStudentsByIndexList(List<String> indexList);

    byte[] getStudentPicture(String index);

    String setStudentPicture(String index, byte[] file);

    void deleteStudent(String index);

    void updateStudent(Student student);

    String findStudentName(String index);
}

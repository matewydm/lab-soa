package pl.edu.agh.kis.soa.service;

import pl.edu.agh.kis.soa.model.json.Course;
import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.model.json.StudentForm;

import java.util.List;

public interface DeanService {

    Student findStudent(Integer index);

    List<Student> getAllStudent();

    List<Student> getStudentsByIndexList(List<Integer> indexList);

    byte[] getStudentPicture(Integer index);

    String setStudentPicture(Integer index, byte[] file);

    void deleteStudent(Integer index);

    void updateStudent(Student student);

    String findStudentName(Integer index);

    void registerStudent(StudentForm studentForm);

    void saveStudent(Student student);

    Course getCourseByName(String name);
}

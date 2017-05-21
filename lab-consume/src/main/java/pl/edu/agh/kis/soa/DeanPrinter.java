package pl.edu.agh.kis.soa;

import pl.edu.agh.kis.soa.generated.Course;
import pl.edu.agh.kis.soa.generated.Student;

import java.util.List;

public class DeanPrinter {

    public void printCourses(List<Course> courseList) {
        for (Course course : courseList) {
            printCourse(course);
        }
    }

    public void printCourse(Course course) {
        System.out.println(course.getName() + " : " + course.getEcts());
    }

    public void printStudents(List<Student> studentList) {
        for (Student student : studentList) {
            printStudent(student);
        }
    }

    public void printStudent(Student student){
        System.out.println(student.getFirstName() + " "
                + student.getSurname() + " : " + student.getIndexNumber());
    }
}

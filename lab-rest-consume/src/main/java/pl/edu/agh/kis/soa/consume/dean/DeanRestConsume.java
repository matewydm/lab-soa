package pl.edu.agh.kis.soa.consume.dean;

import pl.edu.agh.kis.soa.model.json.Course;
import pl.edu.agh.kis.soa.model.json.Student;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class DeanRestConsume {

    private static final String REST_URL = "http://localhost:8080/lab-rest/rest/dean";
    private Client client;

    public Student getStudentPathParam(Integer index) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/{index}");
        Student object = target
                        .resolveTemplate("index",index)
                        .request(MediaType.APPLICATION_JSON)
                        .get(Student.class);
        client.close();
        return object;
    }

    public Student getStudent(Integer index) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL);
        Student student = target
                .queryParam("index",index)
                .request()
                .get(Student.class);
        client.close();
        return student;
    }

    public void deleteStudent(Integer index) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/{index}");
        target
                .resolveTemplate("index",index)
                .request()
                .delete();
        client.close();
    }

    public void saveStudent() {
        Student student = new Student();
        student.setFirstName("Dare");
        student.setSurname("Tii");
        student.setIndexNumber(11111);
        student.setCourses(getCourse("PSI"));
        student.setCourses(getCourse("TKiK"));

        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL);
        target.request()
              .post(Entity.json(student),Student.class);
        client.close();
    }

    public void saveStudentGenCourse() {
        Student student = new Student();
        student.setFirstName("Dare");
        student.setSurname("Tii");
        student.setIndexNumber(112);
        student.setCourses(generateCourse("AiMO",5));
        student.setCourses(generateCourse("IO",4));

        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL);
        target.request()
                .post(Entity.json(student),Student.class);
        client.close();
    }

    public List<Student> getAllStudent() {

        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/all");
        List<Student> studentList = target.request().get(List.class);
        client.close();
        return studentList;
    }

    public Course getCourse(String name) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/course");
        Course course = target
                .queryParam("name",name)
                .request()
                .get(Course.class);
        client.close();
        return course;
    }

    private Course generateCourse(String name, Integer ects) {
        Course course = new Course();
        course.setName(name);
        course.setEcts(ects);
        return course;
    }
}

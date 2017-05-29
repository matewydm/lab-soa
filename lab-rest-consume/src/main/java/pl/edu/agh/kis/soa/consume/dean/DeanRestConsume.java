package pl.edu.agh.kis.soa.consume.dean;

import pl.edu.agh.kis.soa.model.json.Student;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
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
        student.setIndexNumber(271821);
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
        return studentList;
    }


}

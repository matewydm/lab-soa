package pl.edu.agh.kis.soa.consume.dean;

import pl.edu.agh.kis.soa.model.json.Student;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class DeanRestConsume {

    private static final String REST_URL = "http://localhost:8080/lab-rest/rest/dean";
    private Client client;

    public String getStudentName(String index) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/name");
        String object = target
                        .path(index)
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        client.close();
        return object;
    }

    public Student getStudent(String index) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/name");
        Student student = target
                .path(index)
                .request(MediaType.APPLICATION_JSON)
                .get(Student.class);
        client.close();
        return student;
    }

    public List<Student> getStudents(List<String> indexList) {
        client = ClientBuilder.newClient();
        Form indexListForm = new Form();
        indexList.stream().forEach(index -> indexListForm.param("indexList",index));
        WebTarget target = client.target(REST_URL + "/name");
        List<Student> studentList;
//        studentList = target
//                .request(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
//                .accept(MediaType.TEXT_XML)
//                .post(indexListForm,String.class);

        client.close();
        return null;
    }

    public void deleteStudent(String index) {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/name");
        target
            .path(index)
            .request()
            .delete();
        client.close();
    }

    public List<Student> getAllStudent() {

        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_URL + "/all");
        List<Student> studentList = target.request().get(List.class);
        return studentList;
    }


}

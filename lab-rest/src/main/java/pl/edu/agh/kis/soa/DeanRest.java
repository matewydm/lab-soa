package pl.edu.agh.kis.soa;


import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.spi.HttpRequest;
import pl.edu.agh.kis.soa.model.json.Course;
import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.model.json.StudentForm;
import pl.edu.agh.kis.soa.service.DeanService;
import pl.edu.agh.kis.soa.service.MockDean;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;

@Path("/dean")
public class DeanRest {

    @Inject
    private DeanService deanService;

    @GET
    @Path("/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("index") Integer index){
        return deanService.findStudent(index);
    }

    @GET
    @Path("/name/{index}")
    public String getStudentName(@PathParam("index") Integer index){
        return deanService.findStudentName(index);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent(){
        return deanService.getAllStudent();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@QueryParam(value = "index") Integer index){
        return deanService.findStudent(index);
    }

    @GET
    @Path("/picture/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public byte[] getPictureByIndex(@PathParam(value = "index") Integer index){
        return deanService.getStudentPicture(index);
    }

    @DELETE
    @Path("/{index}")
    public void deleteStudent(@PathParam("index") Integer index){
        deanService.deleteStudent(index);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateStudent(Student student){
        deanService.updateStudent(student);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveStudent(Student student){
        deanService.saveStudent(student);
    }

    @GET
    @Path("/course")
    @Produces(MediaType.APPLICATION_JSON)
    public Course saveStudent(@QueryParam(value = "name") String name){
        return deanService.getCourseByName(name);
    }

    @GET
    @Path("/picture/{index}")
    @Consumes(MediaType.APPLICATION_JSON)
    public byte[] getStudentPicture(@PathParam("index") Integer index){
        return deanService.getStudentPicture(index);
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerStudent(@Valid @MultipartForm StudentForm studentForm,
                                    @Context HttpRequest request) {

        deanService.registerStudent(studentForm);
        return Response.ok().build();
    }
}

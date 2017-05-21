package pl.edu.agh.kis.soa;


import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.service.DeanService;
import pl.edu.agh.kis.soa.service.MockDean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/dean")
public class DeanRest {

    @Inject
    @MockDean
    private DeanService deanService;

    @GET
    @Path("/{index}")
    public Student getStudent(@PathParam("index") String index){
        return deanService.findStudent(index);
    }

    @GET
    @Path("/name/{index}")
    public String getStudentName(@PathParam("index") String index){
        return deanService.findStudentName(index);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent(){
        return deanService.getAllStudent();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent(@QueryParam(value = "indexList") List<String> indexList){
        return deanService.getStudentsByIndexList(indexList);
    }

    @DELETE
    @Path("/{index}")
    public void deleteStudent(@PathParam("index") String index){
        deanService.deleteStudent(index);
    }

    @PUT
    public void updateStudent(Student student){
        deanService.updateStudent(student);
    }

    @GET
    @Path("/picture/{index}")
    @Consumes(MediaType.APPLICATION_JSON)
    public byte[] getStudentPicture(@PathParam("index") String index){
        return deanService.getStudentPicture(index);
    }
}

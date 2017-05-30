package pl.edu.agh.kis.soa;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.service.DeanService;
import pl.edu.agh.kis.soa.service.MockDean;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Stateless
@WebService
@SecurityDomain(value = "other")
@RolesAllowed("dare")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebContext(contextRoot="/lab-soap", authMethod="BASIC",
        transportGuarantee="NONE", secureWSDLAccess = false)
public class Dean {

    @Inject
    @MockDean
    private DeanService deanService;

    @WebMethod(action = "findStudent")
    @WebResult(name = "getStudent")
    public Student findStudent(@WebParam(name = "index") Integer index) {
        return deanService.findStudent(index);
    }

    @WebMethod(action = "getAll")
    @WebResult(name = "allStudents")
    public List<Student> getAllStudent() {
        return deanService.getAllStudent();
    }

    @WebMethod(action = "getAll")
    @WebResult(name = "allStudents")
    @PermitAll
    public List<Student> getStudentsByIndexList(@WebParam(name = "list") List<Integer> indexList) {
        return deanService.getStudentsByIndexList(indexList);
    }

    @WebMethod(action = "getPicture")
    @WebResult(name = "picture")
    @PermitAll
    public byte[] getStudentPicture(@WebParam(name = "index") Integer index) {
        return deanService.getStudentPictureByte(index);
    }

    @WebMethod(action = "getCourses")
    @WebResult(name = "courses")
    @PermitAll
    public String setStudentPicture(@WebParam(name = "index") Integer index,@WebParam(name = "file") byte[] file) {
        return deanService.setStudentPicture(index,file);
    }

}

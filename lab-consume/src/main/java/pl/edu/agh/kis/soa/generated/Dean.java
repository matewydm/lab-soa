
package pl.edu.agh.kis.soa.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Dean", targetNamespace = "http://soa.kis.agh.edu.pl/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Dean {


    /**
     * 
     * @param list
     * @return
     *     returns pl.edu.agh.kis.soa.generated.StudentArray
     */
    @WebMethod(action = "getAll")
    @WebResult(name = "allStudents", partName = "allStudents")
    public StudentArray getStudentsByIndexList(
        @WebParam(name = "list", partName = "list")
        IntArray list);

    /**
     * 
     * @param index
     * @return
     *     returns pl.edu.agh.kis.soa.generated.Student
     */
    @WebMethod(action = "findStudent")
    @WebResult(name = "getStudent", partName = "getStudent")
    public Student findStudent(
        @WebParam(name = "index", partName = "index")
        int index);

    /**
     * 
     * @param index
     * @return
     *     returns byte[]
     */
    @WebMethod(action = "getPicture")
    @WebResult(name = "picture", partName = "picture")
    public byte[] getStudentPicture(
        @WebParam(name = "index", partName = "index")
        int index);

    /**
     * 
     * @return
     *     returns pl.edu.agh.kis.soa.generated.StudentArray
     */
    @WebMethod(action = "getAll")
    @WebResult(name = "allStudents", partName = "allStudents")
    public StudentArray getAllStudent();

    /**
     * 
     * @param file
     * @param index
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "getCourses")
    @WebResult(name = "courses", partName = "courses")
    public String setStudentPicture(
        @WebParam(name = "index", partName = "index")
        int index,
        @WebParam(name = "file", partName = "file")
        byte[] file);

}

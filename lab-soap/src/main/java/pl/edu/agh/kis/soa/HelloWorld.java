package pl.edu.agh.kis.soa;

import pl.edu.agh.kis.soa.model.json.DTOList;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@Stateless
@WebService
public class HelloWorld {

    @WebMethod
    @PermitAll
    public String hello(String name) {
        return "hello " + name;
    }

    @WebMethod(action = "helloAction")
    @WebResult(name = "greet")
    public String helloAction(@WebParam(name = "name") String name) {
        return "hello " + name;
    }


    @WebMethod(action = "getList")
    @WebResult(name = "list")
    public int getList(@WebParam(name = "list") DTOList list) {
        return list.size();
    }
}

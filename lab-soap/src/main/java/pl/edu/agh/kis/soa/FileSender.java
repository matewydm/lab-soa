package pl.edu.agh.kis.soa;

import org.apache.commons.codec.binary.Base64;
import org.jboss.ejb3.annotation.SecurityDomain;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Stateless
@WebService
public class FileSender{
    @WebMethod
    @WebResult
    public String Send(@WebParam(name="path") String path){
        File file = new File(path);
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.encodeBase64String(bytes);
        } catch (FileNotFoundException e) {
            encodedfile="Nie ma takiego pliku";
        } catch (IOException e) {
            encodedfile="Błąd wysyłania";
        }
        return encodedfile;
    }
}
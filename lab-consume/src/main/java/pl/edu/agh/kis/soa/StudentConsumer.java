package pl.edu.agh.kis.soa;


import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import pl.edu.agh.kis.soa.generated.*;

import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class StudentConsumer {

    private DeanService deanService;
    private Dean dean;

    public StudentConsumer() {
        deanService = new DeanService();
        dean = deanService.getDeanPort();
        Authorizer.setCredentials((BindingProvider) dean);
    }


    public Student getStudentByIndex(int index) {
        return dean.findStudent(index);
    }

    public List<Student> getStudentsByIndexes(List<Integer> indexes) {
        IntArray indexArray = new IntArray();
        indexArray.getItem().addAll(indexes);
        return dean.getStudentsByIndexList(indexArray).getItem();
    }

    public String setPicture(Integer index, String path) {
        byte[] picture = getFileByPath(path);
        return dean.setStudentPicture(index,picture);
    }

    private byte[] getFileByPath(String path) {
        File file = new File(path);
        byte[] byteArray = new byte[(int) file.length()];
        try {
            byteArray = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}

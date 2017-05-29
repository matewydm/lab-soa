package pl.edu.agh.kis.soa.model.json;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

public class StudentForm {

    private Student student = new Student();

    @NotNull
    public Integer getIndex() {
        return student.getIndexNumber();
    }

    @FormParam("index")
    public void setIndex(Integer index) {
        student.setIndexNumber(index);
    }

    @NotNull
    public String getSurname() {
        return student.getSurname();
    }

    @FormParam("surname")
    public void setSurname(String surname) {
        student.setSurname(surname);
    }

    public String getFirstname() {
        return student.getFirstName();
    }

    @FormParam(value = "firstname")
    public void setFirstname(String firstname) {
        student.setFirstName(firstname);
    }

    public byte[] getPicture() {
        return student.getPicture();
    }

    @FormParam("picture")
    @PartType("application/octet-stream")
    public void setPicture(byte[] picture) {
        student.setPicture(picture);
    }


}

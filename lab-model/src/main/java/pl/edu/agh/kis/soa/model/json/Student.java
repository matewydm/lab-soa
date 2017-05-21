package pl.edu.agh.kis.soa.model.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String surname;
    private String indexNumber;
    private String login;
    private byte[] picture;
    @XmlTransient
    private String password;
    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    List<Course> courses = new ArrayList<>();

    public Student(){

    }

    public Student(String firstName, String surname, String indexNumber, String login, byte[] picture, String password, List<Course> courses) {
        this.firstName = firstName;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.login = login;
        this.picture = picture;
        this.password = password;
        this.courses = courses;
    }

    private Student(Builder builder) {
        setFirstName(builder.firstName);
        setSurname(builder.surname);
        setIndexNumber(builder.indexNumber);
        setLogin(builder.login);
        setLogin(builder.login);
        setPicture(builder.picture);
        setPassword(builder.password);
        courses = builder.courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @XmlTransient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(Course course) {
        if(courses==null){
            courses = new ArrayList<Course>();
        }
        courses.add(course);
    }

    public static final class Builder {
        private String firstName;
        private String surname;
        private String indexNumber;
        private String login;
        private String password;
        private byte[] picture;
        private List<Course> courses;

        public Builder() {
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Builder indexNumber(String val) {
            indexNumber = val;
            return this;
        }

        public Builder login(String val) {
            login = val;
            return this;
        }

        public Builder picture(byte[] pic) {
            picture = pic;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder courses(Course val) {
            if(courses==null)
                courses = new ArrayList<Course>();
            courses.add(val);
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "name";
    }
}
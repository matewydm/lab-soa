package pl.edu.agh.kis.soa.model.json;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlTransient
    private String firstName;
    private String surname;
    private String indexNumber;
    private byte[] picture;
    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    List<Course> courses = new ArrayList<>();

    public Student(){

    }

    public Student(String firstName, String surname, String indexNumber, byte[] picture, List<Course> courses) {
        this.firstName = firstName;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.picture = picture;
        this.courses = courses;
    }

    private Student(Builder builder) {
        setFirstName(builder.firstName);
        setSurname(builder.surname);
        setIndexNumber(builder.indexNumber);
        setPicture(builder.picture);
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


    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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

        public Builder picture(byte[] pic) {
            picture = pic;
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
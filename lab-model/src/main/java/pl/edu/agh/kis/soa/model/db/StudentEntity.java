package pl.edu.agh.kis.soa.model.db;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="getAllStudent",
        query="SELECT s FROM StudentEntity s")
@Table(name = "student")
public class StudentEntity {

    private Integer stdIndex;
    private String stdFirstName;
    private String stdSurname;
    private byte[] stdPicture;
    private List<CourseEntity> courses;

    @Id
    @GeneratedValue
    @Column(name = "std_index", nullable = false, unique = true)
    public Integer getStdIndex() {
        return stdIndex;
    }

    public void setStdIndex(Integer indexNumber) {
        this.stdIndex = indexNumber;
    }

    @Column(name = "std_firstname")
    public String getStdFirstName() {
        return stdFirstName;
    }

    public void setStdFirstName(String firstName) {
        this.stdFirstName = firstName;
    }

    @Column(name = "std_surname")
    public String getStdSurname() {
        return stdSurname;
    }

    public void setStdSurname(String surname) {
        this.stdSurname = surname;
    }

    @Column(name = "std_picture")
    public byte[] getStdPicture() {
        return stdPicture;
    }

    public void setStdPicture(byte[] picture) {
        this.stdPicture = picture;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "crsStudent",cascade = CascadeType.ALL)
    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }



}

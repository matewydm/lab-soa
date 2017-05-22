package pl.edu.agh.kis.soa.model.db;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseEntity {

    private Integer crsId;
    private String crsName;
    private Integer crsEcts;
    private StudentEntity crsStudent;

    @Id
    @Column(name = "course_id", nullable = false)
    public Integer getCrsId() {
        return crsId;
    }

    public void setCrsId(Integer crsId) {
        this.crsId = crsId;
    }

    @Column(name = "crs_name", nullable = false)
    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String name) {
        this.crsName = name;
    }

    @Column(name = "crs_ects", nullable = false)
    public Integer getCrsEcts() {
        return crsEcts;
    }

    public void setCrsEcts(Integer ects) {
        this.crsEcts = ects;
    }


    @ManyToOne
    @JoinColumn(name = "crs_std_index")
    public StudentEntity getCrsStudent() {
        return crsStudent;
    }

    public void setCrsStudent(StudentEntity crsStudent) {
        this.crsStudent = crsStudent;
    }
}

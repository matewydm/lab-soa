package pl.edu.agh.kis.soa.model.db;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseEntity {

    private Integer crsId;
    private String crsName;
    private Integer crsEcts;
    private List<StudentEntity> crsStudent;

    @Id
    @Column(name = "crs_id", nullable = false)
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


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "course_student",
            joinColumns = {@JoinColumn(name = "crs_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "std_index", nullable = false)})
    public List<StudentEntity> getCrsStudent() {
        return crsStudent;
    }

    public void setCrsStudent(List<StudentEntity> crsStudent) {
        this.crsStudent = crsStudent;
    }
}

package pl.edu.agh.kis.soa.model.json;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class Course {

    private Integer courseId;
    private String name;
    @XmlElement(name = "ects")
    private Integer ects;

    public Course(String name, Integer ects) {
        this.name = name;
        this.ects = ects;
    }
    public Course() {
    }

    private Course(Builder builder) {
        setName(builder.name);
        setEcts(builder.ects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public static final class Builder {
        private String name;
        private Integer ects;
        private Set<String> lecturers;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder ects(Integer val) {
            ects = val;
            return this;
        }

        public Builder lecturers(Set<String> val) {
            lecturers = val;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}

package pl.edu.agh.kis.soa.model.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.HashSet;
import java.util.Set;

public class Course {

    private String name;
    private Integer ects;
    @XmlElementWrapper(name = "lecturers")
    @XmlElement(name = "lecturer")
    private Set<String> lecturers;

    public Course(String name, Integer ects) {
        this.name = name;
        this.ects = ects;
    }

    private Course(Builder builder) {
        setName(builder.name);
        setEcts(builder.ects);
        lecturers = builder.lecturers;
    }

    public Set<String> getLecturers() {
        return lecturers;
    }

    public void setLecturers(String lecturer) {
        if (lecturers == null) {
            lecturers = new HashSet<>();
        }
        lecturers.add(lecturer);
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

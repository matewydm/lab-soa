package pl.edu.agh.kis.soa.model.mapper;

import pl.edu.agh.kis.soa.model.db.StudentEntity;
import pl.edu.agh.kis.soa.model.json.Student;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentMapper {

    @Inject
    private CourseMapper courseMapper;

    public Student entityToJson(StudentEntity studentEntity) {
        if (studentEntity != null) {
            Student student = new Student();
            student.setIndexNumber(studentEntity.getStdIndex());
            student.setFirstName(studentEntity.getStdFirstName());
            student.setSurname(studentEntity.getStdSurname());
            student.setPicture(studentEntity.getStdPicture());
            studentEntity.getCourses().stream().forEach(courseEntity -> student.setCourses(courseMapper.entityToJson(courseEntity)));

            return student;
        }
        return null;
    }

    public StudentEntity jsonToEntity(Student student) {
        if (student != null) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStdIndex(student.getIndexNumber());
            studentEntity.setStdFirstName(student.getFirstName());
            studentEntity.setStdSurname(student.getSurname());
            studentEntity.setStdPicture(student.getPicture());
            studentEntity.setCourses(courseMapper.jsonListToEntityList(student.getCourses()));

            return studentEntity;
        }
        return null;
    }

    public List<Student> entityListToJsonList(List<StudentEntity> studentEntityList) {
        if (studentEntityList != null) {
            List<Student> studentList = new ArrayList<>();
            studentEntityList.stream().forEach(studentEntity -> studentList.add(entityToJson(studentEntity)));
            return studentList;
        }
        return null;
    }

    public List<StudentEntity> jsonListToEntityList(List<Student> studentList) {
        if (studentList != null) {
            List<StudentEntity> studentEntityList = new ArrayList<>();
            studentList.stream().forEach(student -> studentEntityList.add(jsonToEntity(student)));
            return studentEntityList;
        }
        return null;
    }


}

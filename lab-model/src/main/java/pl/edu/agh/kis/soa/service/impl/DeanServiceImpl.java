package pl.edu.agh.kis.soa.service.impl;


import pl.edu.agh.kis.soa.dao.CourseRepository;
import pl.edu.agh.kis.soa.dao.StudentRepository;
import pl.edu.agh.kis.soa.model.db.StudentEntity;
import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.model.mapper.StudentMapper;
import pl.edu.agh.kis.soa.service.DeanService;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

@Default
public class DeanServiceImpl implements DeanService{

    @Inject
    private CourseRepository courseRepository;
    @Inject
    private StudentRepository studentRepository;
    @Inject
    private StudentMapper studentMapper;

    @Override
    public Student findStudent(String index) {
        return studentMapper.entityToJson(studentRepository.get(index));
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.entityListToJsonList(studentRepository.getAll());
    }

    @Override
    public List<Student> getStudentsByIndexList(List<String> indexList) {
        return null;
    }

    @Override
    public byte[] getStudentPicture(String index) {
        return new byte[0];
    }

    @Override
    public String setStudentPicture(String index, byte[] file) {
        return null;
    }

    @Override
    public void deleteStudent(String index) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStdIndex(index);
        studentRepository.delete(studentEntity);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(studentMapper.jsonToEntity(student));
    }

    @Override
    public String findStudentName(String index) {
        return studentRepository.getStudentName(index);
    }

    @Override
    public void registerStudent(String index, String firstname, String surname) {
        Student student = new Student();
        student.setIndexNumber(index);
        student.setFirstName(firstname);
        student.setSurname(surname);
        StudentEntity studentEntity = studentMapper.jsonToEntity(student);
        studentRepository.save(studentEntity);
    }
}

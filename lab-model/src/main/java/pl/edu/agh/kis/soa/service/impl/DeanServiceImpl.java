package pl.edu.agh.kis.soa.service.impl;


import pl.edu.agh.kis.soa.dao.CourseRepository;
import pl.edu.agh.kis.soa.dao.StudentRepository;
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
        return null;
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

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public String findStudentName(String index) {
        return null;
    }
}

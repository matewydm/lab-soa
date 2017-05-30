package pl.edu.agh.kis.soa.service.impl;

import pl.edu.agh.kis.soa.dao.CourseDao;
import pl.edu.agh.kis.soa.dao.StudentDao;
import pl.edu.agh.kis.soa.model.db.StudentEntity;
import pl.edu.agh.kis.soa.model.json.Course;
import pl.edu.agh.kis.soa.model.json.Student;
import pl.edu.agh.kis.soa.model.json.StudentForm;
import pl.edu.agh.kis.soa.model.mapper.CourseMapper;
import pl.edu.agh.kis.soa.model.mapper.StudentMapper;
import pl.edu.agh.kis.soa.service.DeanService;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@Default
public class DeanServiceImpl implements DeanService{

    @Inject
    private StudentDao studentDao;
    @Inject
    private CourseDao courseDao;
    @Inject
    private StudentMapper studentMapper;
    @Inject
    private CourseMapper courseMapper;

    @Override
    public Student findStudent(Integer index) {
        return studentMapper.entityToJson(studentDao.get(index));
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.entityListToJsonList(studentDao.getAll());
    }

    @Override
    public List<Student> getStudentsByIndexList(List<Integer> indexList) {
        return null;
    }

    @Override
    public Response getStudentPicture(Integer index) {
        byte[] picture =  studentDao.getPictureByIndex(index);
        if (picture != null) {
            Response.ResponseBuilder responseBuilder = Response.ok(picture);
            responseBuilder.header("Content-Disposition","attachment;filename=dare.jpg");
            return responseBuilder.build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @Override
    public byte[] getStudentPictureByte(Integer index) {
        return new byte[0];
    }

    @Override
    public String setStudentPicture(Integer index, byte[] file) {
        return null;
    }

    @Override
    public void deleteStudent(Integer index) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStdIndex(index);
        studentDao.delete(studentEntity);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(studentMapper.jsonToEntity(student));
    }

    @Override
    public String findStudentName(Integer index) {
        return studentDao.getStudentName(index);
    }

    @Override
    public void registerStudent(StudentForm studentForm) {
        Student student = new Student();
        student.setIndexNumber(studentForm.getIndex());
        student.setFirstName(studentForm.getFirstname());
        student.setSurname(studentForm.getSurname());
        student.setPicture(studentForm.getPicture());
        StudentEntity studentEntity = studentMapper.jsonToEntity(student);
        studentDao.save(studentEntity);
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.save(studentMapper.jsonToEntity(student));
    }

    @Override
    public Course getCourseByName(String name) {
        return courseMapper.entityToJson(courseDao.getByName(name));
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

}

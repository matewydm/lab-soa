package pl.edu.agh.kis.soa.dao;

import pl.edu.agh.kis.soa.model.db.StudentEntity;

import javax.ejb.Local;
import java.util.List;

public interface StudentDao {

    void save(StudentEntity student);

    void update(StudentEntity student);

    void delete(StudentEntity student);

    List<StudentEntity> getAll();

    StudentEntity get(Integer index);

    String getStudentName(Integer index);
}

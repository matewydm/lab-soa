package pl.edu.agh.kis.soa.dao;

import org.hibernate.Session;
import pl.edu.agh.kis.soa.model.db.CourseEntity;
import pl.edu.agh.kis.soa.model.db.StudentEntity;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class StudentRepository {

    @PersistenceContext(unitName = "PostgresDS", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void save(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.save(student);
    }

    public void update(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.update(student);
    }

    public void delete(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(student);
    }

    public StudentEntity get(String index) {
        Session session = entityManager.unwrap(Session.class);
        return (StudentEntity) session.get(StudentEntity.class,index);
    }
}

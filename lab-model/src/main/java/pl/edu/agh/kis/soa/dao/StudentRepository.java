package pl.edu.agh.kis.soa.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.agh.kis.soa.model.db.StudentEntity;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Stateful
public class StudentRepository {

    @PersistenceContext(unitName = "PostgresDS", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void save(StudentEntity student) {
        entityManager.persist(student);
    }

    public void update(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.update(student);
    }

    public void delete(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(student);
    }

    public List<StudentEntity> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createCriteria(StudentEntity.class).list();
    }

    public StudentEntity get(String index) {
        Session session = entityManager.unwrap(Session.class);
        return (StudentEntity) session.get(StudentEntity.class,index);
    }

    public String getStudentName(String index) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("SELECT student.stdFirstName FROM StudentEntity student WHERE " +
                "student.stdIndex = :index")
                .setString("index",index);
        return (String) query.uniqueResult();
    }
}

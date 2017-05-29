package pl.edu.agh.kis.soa.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.agh.kis.soa.dao.StudentDao;
import pl.edu.agh.kis.soa.model.db.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentRepository implements StudentDao{

    public StudentRepository() {
    }

    @PersistenceContext(unitName = "PostgresDS", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void save(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.save(student);
    }

    @Override
    public void update(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.update(student);
    }

    @Override
    public void delete(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(student);
    }

    @Override
    public List<StudentEntity> getAll() {
        return entityManager.createNamedQuery("getAllStudent").getResultList();
    }

    @Override
    public StudentEntity get(Integer index) {
        Session session = entityManager.unwrap(Session.class);
        return (StudentEntity) session.get(StudentEntity.class,index);
    }

    @Override
    public String getStudentName(Integer index) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("SELECT student.stdFirstName FROM StudentEntity student WHERE " +
                "student.stdIndex = :index")
                .setInteger("index",index);
        return (String) query.uniqueResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
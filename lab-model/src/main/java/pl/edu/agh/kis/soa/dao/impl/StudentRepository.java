package pl.edu.agh.kis.soa.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.agh.kis.soa.dao.StudentDao;
import pl.edu.agh.kis.soa.model.db.CourseEntity;
import pl.edu.agh.kis.soa.model.db.StudentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentRepository implements StudentDao, Serializable{

    public StudentRepository() {
    }

    @PersistenceContext(unitName = "PostgresDS")
    private EntityManager entityManager;

    @Override
    public void save(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        List<CourseEntity> courseEntities = new ArrayList<>();
        for (CourseEntity course : student.getCourses()) {
            CourseEntity updatedCourse = null;
            if (course.getCrsId() != null) {
                updatedCourse = entityManager.find(CourseEntity.class,course.getCrsId());
                courseEntities.add(updatedCourse);
            } else {
                entityManager.persist(course);
                courseEntities.add(course);
            }
        }
        student.setCourses(courseEntities);
        entityManager.persist(student);
    }

    @Override
    public void update(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        session.update(student);
    }

    @Override
    public void delete(StudentEntity student) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createSQLQuery("DELETE FROM course_student WHERE " +
            "std_index = :index")
            .setInteger("index",student.getStdIndex());
        query.executeUpdate();
        StudentEntity entity = entityManager.merge(student);
        entityManager.remove(entity);
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

    @Override
    public byte[] getPictureByIndex(Integer index) {
        return (byte[]) entityManager
                .createQuery("SELECT student.stdPicture FROM StudentEntity student WHERE " +
                "student.stdIndex = :index")
                .setParameter("index",index)
                .getSingleResult();

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

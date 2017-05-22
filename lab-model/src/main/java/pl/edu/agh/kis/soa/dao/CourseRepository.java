package pl.edu.agh.kis.soa.dao;

import org.hibernate.Session;
import pl.edu.agh.kis.soa.model.db.CourseEntity;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class CourseRepository {

    @PersistenceContext(unitName = "PostgresDS", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void save(CourseEntity course) {
        Session session = entityManager.unwrap(Session.class);
        session.save(course);
    }

    public void update(CourseEntity course) {
        Session session = entityManager.unwrap(Session.class);
        session.update(course);
    }

    public void delete(CourseEntity course) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(course);
    }


}

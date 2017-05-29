package pl.edu.agh.kis.soa.dao.impl;

import org.hibernate.Session;
import pl.edu.agh.kis.soa.dao.CourseDao;
import pl.edu.agh.kis.soa.model.db.CourseEntity;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public class CourseRepository implements CourseDao,Serializable {

    public CourseRepository() {
    }

    @PersistenceContext(unitName = "PostgresDS", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void save(CourseEntity course) {
        Session session = entityManager.unwrap(Session.class);
        session.save(course);
    }

    @Override
    public void update(CourseEntity course) {
        Session session = entityManager.unwrap(Session.class);
        session.update(course);
    }

    @Override
    public void delete(CourseEntity course) {
        CourseEntity entity = entityManager.merge(course);
        entityManager.remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

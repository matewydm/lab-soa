package pl.edu.agh.kis.soa.dao;


import pl.edu.agh.kis.soa.model.db.CourseEntity;

import javax.ejb.Local;

public interface CourseDao {

    void save(CourseEntity course);

    void update(CourseEntity course);

    void delete(CourseEntity course);
}

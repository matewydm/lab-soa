package pl.edu.agh.kis.soa.model.mapper;

import pl.edu.agh.kis.soa.model.db.CourseEntity;
import pl.edu.agh.kis.soa.model.json.Course;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CourseMapper {

    public Course entityToJson(CourseEntity courseEntity) {
        if (courseEntity != null) {
            Course course = new Course();
            course.setCourseId(courseEntity.getCrsId());
            course.setName(courseEntity.getCrsName());
            course.setEcts(courseEntity.getCrsEcts());
            return course;
        }
        return null;
    }


    public CourseEntity jsonToEntity(Course course) {
        if (course != null) {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setCrsId(course.getCourseId());
            courseEntity.setCrsName(course.getName());
            courseEntity.setCrsEcts(course.getEcts());
            return courseEntity;
        }
        return null;
    }

    public List<Course> entityListToJsonList(List<CourseEntity> courseEntityList) {
        if (courseEntityList != null) {
            List<Course> courseList = new ArrayList<>();
            courseEntityList.stream().forEach(courseEntity -> courseList.add(entityToJson(courseEntity)));
            return courseList;
        }
        return null;
    }

    public List<CourseEntity> jsonListToEntityList(List<Course> courseList) {
        if (courseList != null) {
            List<CourseEntity> courseEntityList = new ArrayList<>();
            courseList.stream().forEach(course -> courseEntityList.add(jsonToEntity(course)));
            return courseEntityList;
        }
        return null;
    }

}

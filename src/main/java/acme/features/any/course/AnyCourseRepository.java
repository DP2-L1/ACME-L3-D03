
package acme.features.any.course;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.course.Course;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyCourseRepository extends AbstractRepository {

	@Query("Select c from Course c")
	Collection<Course> findAllCourses();

	@Query("Select c from Course c where c.draftMode = false")
	Collection<Course> findNotInDrfatCourses();

	@Query("Select c from Course c where c.id = :id")
	Course findCourseById(int id);

}

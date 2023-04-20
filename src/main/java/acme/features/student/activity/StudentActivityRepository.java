package acme.features.student.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.course.Course;
import acme.entities.enrolment.Enrolment;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface StudentActivityRepository extends AbstractRepository {

	@Query("SELECT act FROM Activity act")
	Collection<Activity> findAllActivities();

	@Query("SELECT c FROM Course c WHERE c.id = :id")
	Course findCourseById(int id);

	@Query("SELECT act FROM Activity act WHERE act.id = :id")
	Activity findActivityById(int id);

	@Query("SELECT act FROM Activity act WHERE act.enrolment.id = :id")
	Collection<Activity> findAllActivitiesByEnrolment(int id);

	@Query("SELECT enr FROM Enrolment enr WHERE enr.id = :id")
	Enrolment findEnrolmentById(int id);

}
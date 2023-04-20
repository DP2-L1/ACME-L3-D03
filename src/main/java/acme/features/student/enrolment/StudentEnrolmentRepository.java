
package acme.features.student.enrolment;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.course.Course;
import acme.entities.enrolment.Enrolment;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Student;

@Repository
public interface StudentEnrolmentRepository extends AbstractRepository {

	@Query("select enr from Enrolment enr where enr.id = :enrolmentId")
	Enrolment findEnrolmentById(int enrolmentId);

	@Query("select enr from Enrolment enr where enr.student.id = :id")
	Collection<Enrolment> findEnrolmentsByStudentId(int id);

	@Query("select c from Course c left join Enrolment enr where enr.id = :enrolmentId")
	Course findCourseByEnrolmentId(int enrolmentId);

	@Query("select act from Activity act where act.enrolment.id = :id")
	Collection<Activity> findManyActivitiesByEnrolmentId(int id);

	@Query("select enr from Enrolment enr")
	Collection<Enrolment> findAllEnrolments();

	@Query("select c from Course c")
	Collection<Course> findAllCourses();

	@Query("select st from Student st where st.id = :id")
	Student findStudentById(int id);

	@Query("select c from Course c where c.draftMode = false")
	Collection<Course> findNotInDraftCourses();

	@Query("select c from Course c where c.id = :id")
	Course findCourseById(int id);

	@Query("select enr from Enrolment enr where enr.code = :code")
	Enrolment findAEnrolmentByCode(String code);

	@Query("select enr.code from Enrolment enr")
	Collection<String> findAllCodesFromEnrolments();

}


package acme.features.student.enrolment;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.course.Course;
import acme.entities.enrolment.Enrolment;
import acme.framework.components.jsp.SelectChoices;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Student;

@Service
public class StudentEnrolmentDeleteService extends AbstractService<Student, Enrolment> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected StudentEnrolmentRepository repository;


	// AbstractService interface ----------------------------------------------
	@Override
	public void check() {
		boolean status;
		status = super.getRequest().hasData("id", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int enrolmentId;
		Enrolment enrolment;
		Student student;
		enrolmentId = super.getRequest().getData("id", int.class);
		enrolment = this.repository.findEnrolmentById(enrolmentId);
		student = enrolment == null ? null : enrolment.getStudent();
		status = (enrolment != null || super.getRequest().getPrincipal().hasRole(student)) && enrolment.isDraftMode();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Enrolment object;
		int id;
		id = super.getRequest().getData("id", int.class);
		object = this.repository.findEnrolmentById(id);
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Enrolment object) {
		assert object != null;
		int studentId;
		Student student;
		int courseId;
		Course course;
		studentId = super.getRequest().getPrincipal().getActiveRoleId();
		student = this.repository.findStudentById(studentId);
		courseId = super.getRequest().getData("course", int.class);
		course = this.repository.findCourseById(courseId);
		super.bind(object, "code", "motivation", "goals");
		object.setStudent(student);
		object.setCourse(course);
	}

	@Override
	public void unbind(final Enrolment object) {
		assert object != null;
		SelectChoices choices;
		Collection<Course> courses;
		Tuple tuple;
		courses = this.repository.findNotInDraftCourses();
		choices = SelectChoices.from(courses, "title", object.getCourse());
		tuple = super.unbind(object, "code", "motivation", "goals", "course");
		tuple.put("course", choices.getSelected().getKey());
		tuple.put("courses", choices);
		super.getResponse().setData(tuple);
	}

	@Override
	public void validate(final Enrolment object) {
		assert object != null;
	}

	@Override
	public void perform(final Enrolment object) {
		assert object != null;
		final Collection<Activity> activities = this.repository.findManyActivitiesByEnrolmentId(object.getId());
		this.repository.deleteAll(activities);
		this.repository.delete(object);
	}

}

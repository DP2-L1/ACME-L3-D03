package acme.features.student.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.AbstractService;

import acme.entities.activity.Activity;
import acme.entities.enrolment.Enrolment;
import acme.roles.Student;

@Service
public class StudentActivityDeleteService extends AbstractService<Student, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected StudentActivityRepository repository;

	// AbstractService<Student, Activity> ---------------------------

	@Override
	public void check() {
		boolean status;
		status = super.getRequest().hasData("id", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		Student student;
		Enrolment enrolment;
		Activity activity;
		int id;
		id = super.getRequest().getData("id", int.class);
		activity = this.repository.findActivityById(id);
		enrolment = activity.getEnrolment();
		student = enrolment == null ? null : enrolment.getStudent();
		status = (enrolment != null || super.getRequest().getPrincipal().hasRole(student)) && enrolment.isDraftMode();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		final int id = super.getRequest().getData("id", int.class);
		final Activity activity = this.repository.findActivityById(id);
		super.getBuffer().setData(activity);
	}

	@Override
	public void bind(final Activity object) {
		assert object != null;
		super.bind(object, "title", "abstractActivity", "activityType", "startPeriod", "endPeriod", "link");
	}

	@Override
	public void unbind(final Activity object) {
		assert object != null;
		Tuple tuple;
		tuple = super.unbind(object, "title", "abstractActivity", "activityType", "startPeriod", "endPeriod", "link");
		super.getResponse().setData(tuple);
	}

	@Override
	public void validate(final Activity object) {
		assert object != null;
	}

	@Override
	public void perform(final Activity object) {
		assert object != null;
		this.repository.delete(object);
	}

}
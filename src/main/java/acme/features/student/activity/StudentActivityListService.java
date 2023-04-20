package acme.features.student.activity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.AbstractService;

import acme.entities.activity.Activity;
import acme.entities.enrolment.Enrolment;
import acme.roles.Student;

@Service
public class StudentActivityListService extends AbstractService<Student, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected StudentActivityRepository repo;

	// AbstractService<Authenticated, Consumer> ---------------------------

	@Override
	public void check() {
		boolean status;
		status = super.getRequest().hasData("enrolmentId", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		int enrolmentId;
		boolean status;
		Enrolment enrolment;
		Student student;
		enrolmentId = super.getRequest().getData("enrolmentId", int.class);
		enrolment = this.repo.findEnrolmentById(enrolmentId);
		student = enrolment == null ? null : enrolment.getStudent();
		status = enrolment != null || super.getRequest().getPrincipal().hasRole(student);
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void unbind(final Activity object) {
		assert object != null;
		Tuple tuple;
		tuple = super.unbind(object, "title", "activityType");
		super.getResponse().setData(tuple);
	}

	@Override
	public void load() {
		Enrolment enrolment;
		Collection<Activity> activities;
		final int enrolmentId = super.getRequest().getData("enrolmentId", int.class);
		activities = this.repo.findAllActivitiesByEnrolment(enrolmentId);
		enrolment = this.repo.findEnrolmentById(enrolmentId);
		super.getResponse().setGlobal("draftMode", enrolment.isDraftMode());
		super.getResponse().setGlobal("enrolmentId", enrolmentId);
		super.getBuffer().setData(activities);
	}

}
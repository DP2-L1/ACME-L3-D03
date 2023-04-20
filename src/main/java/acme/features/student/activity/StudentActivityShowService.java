package acme.features.student.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.AbstractService;

import acme.entities.activity.Activity;
import acme.entities.activity.ActivityType;
import acme.entities.enrolment.Enrolment;
import acme.framework.components.jsp.SelectChoices;
import acme.roles.Student;

@Service
public class StudentActivityShowService extends AbstractService<Student, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected StudentActivityRepository repo;

	// AbstractService<Student, Activity> ---------------------------

	@Override
	public void authorise() {
		boolean status;
		final int activityId = super.getRequest().getData("id", int.class);
		final Activity activity = this.repo.findActivityById(activityId);
		final int id = super.getRequest().getPrincipal().getAccountId();
		status = activity.getEnrolment().getStudent().getUserAccount().getId() == id;
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void check() {
		boolean status;
		status = super.getRequest().hasData("id", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void load() {
		Enrolment enrolment;
		Activity activity;
		final int id = super.getRequest().getData("id", int.class);
		activity = this.repo.findActivityById(id);
		enrolment = activity.getEnrolment();
		super.getResponse().setGlobal("draftMode", enrolment.isDraftMode());
		super.getBuffer().setData(activity);
	}

	@Override
	public void unbind(final Activity object) {
		assert object != null;
		Tuple tuple;
		final SelectChoices choices = SelectChoices.from(ActivityType.class, object.getActivityType());
		tuple = super.unbind(object, "title", "abstractActivity", "activityType", "startPeriod", "endPeriod", "link");
		tuple.put("choicesActivityType", choices);
		super.getResponse().setData(tuple);
	}

}
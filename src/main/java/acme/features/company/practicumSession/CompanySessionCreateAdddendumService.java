
package acme.features.company.practicumSession;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.practicum.Practicum;
import acme.entities.practicum.PracticumSession;
import acme.framework.components.models.Tuple;
import acme.framework.helpers.MomentHelper;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanySessionCreateAdddendumService extends AbstractService<Company, PracticumSession> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected CompanySessionRepository repository;

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
		int masterId;
		Practicum practicum;

		masterId = super.getRequest().getData("id", int.class);
		practicum = this.repository.findOnePracticumById(masterId);
		status = practicum != null && !practicum.isDraftMode() && !practicum.isHasAddendum() && super.getRequest().getPrincipal().hasRole(practicum.getCompany());

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		PracticumSession object;
		int masterId;
		Practicum practicum;
		Date moment;

		moment = MomentHelper.getCurrentMoment();
		masterId = super.getRequest().getData("id", int.class);
		practicum = this.repository.findOnePracticumById(masterId);

		object = new PracticumSession();
		object.setTitle("");
		object.setTimePeriodStart(moment);
		object.setTimePeriodEnd(moment);
		object.setSessionAbstract("");
		object.setPracticum(practicum);
		object.setOptionalLink("");

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final PracticumSession object) {
		assert object != null;

		super.bind(object, "title", "timePeriodStart", "timePeriodEnd", "sessionAbstract", "optionalLink");
	}

	@Override
	public void validate(final PracticumSession object) {
		assert object != null;
		boolean confirmation;

		confirmation = super.getRequest().getData("confirmation", boolean.class);
		super.state(confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");

		if (!super.getBuffer().getErrors().hasErrors("timePeriodStart")) {
			Date minWeekAhead;

			minWeekAhead = MomentHelper.deltaFromCurrentMoment(7, ChronoUnit.DAYS);
			super.state(MomentHelper.isAfter(object.getTimePeriodStart(), minWeekAhead), "timePeriodStart", "Company.PracticumSession.form.error.too-close");
		}
		if (!super.getBuffer().getErrors().hasErrors("timePeriodEnd"))
			super.state(MomentHelper.isAfter(object.getTimePeriodEnd(), object.getTimePeriodStart()), "timePeriodEnd", "Company.PracticumSession.form.error.end-after-start");
		if (!super.getBuffer().getErrors().hasErrors("timePeriodEnd"))
			super.state(MomentHelper.isLongEnough(object.getTimePeriodStart(), object.getTimePeriodEnd(), 7, ChronoUnit.DAYS), "timePeriodEnd", "Company.PracticumSession.form.error.at-least-1-week");
	}

	@Override
	public void perform(final PracticumSession object) {
		assert object != null;
		Duration estimatedTime;
		Practicum practicum;
		Integer practicumTime;

		practicum = this.repository.findOnePracticumById(object.getPracticum().getId());
		practicumTime = practicum.getEstimatedTime();

		estimatedTime = MomentHelper.computeDuration(object.getTimePeriodStart(), object.getTimePeriodEnd());

		practicum.setEstimatedTime((int) (practicumTime + estimatedTime.toHours()));

		practicum.setHasAddendum(true);
		object.setAddendum(true);
		this.repository.save(object);
		this.repository.save(practicum);
	}

	@Override
	public void unbind(final PracticumSession object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "title", "timePeriodStart", "timePeriodEnd", "sessionAbstract", "practicum", "optionalLink");
		tuple.put("id", super.getRequest().getData("id", int.class));
		tuple.put("draftMode", object.getPracticum().isDraftMode());
		tuple.put("hasAddendum", object.getPracticum().isHasAddendum());
		tuple.put("confirmation", false);
		super.getResponse().setData(tuple);
	}
}

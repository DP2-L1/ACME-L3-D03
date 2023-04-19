
package acme.features.company.practicumSession;

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
public class CompanySessionUpdateService extends AbstractService<Company, PracticumSession> {

	@Autowired
	protected CompanySessionRepository repository;


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("id", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int SessionId;
		Practicum practicum;

		SessionId = super.getRequest().getData("id", int.class);
		practicum = this.repository.findOnePracticumBySessionId(SessionId);
		status = practicum != null && (!practicum.isDraftMode() || super.getRequest().getPrincipal().hasRole(practicum.getCompany()));

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		PracticumSession object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneSessionById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final PracticumSession object) {
		assert object != null;

		super.bind(object, "title", "timePeriodStart", "timePeriodEnd", "sessionAbstract", "practicum", "optionalLink");
	}

	@Override
	public void validate(final PracticumSession object) {
		assert object != null;

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

		this.repository.save(object);
	}

	@Override
	public void unbind(final PracticumSession object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "title", "timePeriodStart", "timePeriodEnd", "sessionAbstract", "practicum", "optionalLink");
		tuple.put("id", super.getRequest().getData("id", int.class));
		//tuple.put("draftMode", object.getTutorial().isDraftMode());

		super.getResponse().setData(tuple);
	}
}

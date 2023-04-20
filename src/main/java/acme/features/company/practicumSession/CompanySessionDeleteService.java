
package acme.features.company.practicumSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.practicum.Practicum;
import acme.entities.practicum.PracticumSession;
import acme.framework.components.models.Tuple;
import acme.framework.helpers.MomentHelper;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanySessionDeleteService extends AbstractService<Company, PracticumSession> {

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
		status = practicum != null && practicum.isDraftMode() && super.getRequest().getPrincipal().hasRole(practicum.getCompany());

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

		super.bind(object, "title", "timePeriodStart", "timePeriodEnd", "sessionAbstract", "optionalLink");
	}

	@Override
	public void validate(final PracticumSession object) {
		assert object != null;
	}

	@Override
	public void perform(final PracticumSession object) {
		assert object != null;

		Integer estimatedTime;
		Practicum practicum;
		Integer practicumTime;

		practicum = this.repository.findOnePracticumById(object.getPracticum().getId());
		practicumTime = practicum.getEstimatedTime();

		estimatedTime = (int) MomentHelper.computeDuration(object.getTimePeriodStart(), object.getTimePeriodEnd()).toHours();

		practicum.setEstimatedTime(practicumTime - estimatedTime);
		this.repository.save(practicum);

		this.repository.delete(object);
	}

	@Override
	public void unbind(final PracticumSession object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "title", "timePeriodStart", "timePeriodEnd", "sessionAbstract", "optionalLink");
		tuple.put("masterId", super.getRequest().getData("masterId", int.class));
		tuple.put("draftMode", object.getPracticum().isDraftMode());

		super.getResponse().setData(tuple);
	}
}

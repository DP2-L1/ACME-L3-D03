
package acme.features.company.practicum;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.practicum.Practicum;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanyPracticumCreateService extends AbstractService<Company, Practicum> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected CompanyPracticumRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Practicum object;
		final Company company;
		final Date estimatedTime;
		int companyId;

		companyId = super.getRequest().getPrincipal().getActiveRoleId();
		company = this.repository.findOneCompanyById(companyId);

		object = new Practicum();
		object.setCode("");
		object.setTitle("");
		object.setPracticumAbstract("");
		object.setGoals("");
		object.setCourse(null);
		object.setCompany(company);
		object.setDraftMode(true);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Practicum object) {
		assert object != null;
		assert object.getCourse() != null;

		super.bind(object, "code", "title", "practicumAbstract", "goals", "estimatedTime", "company", "course");
	}

	@Override
	public void validate(final Practicum object) {
		assert object != null;

	}

	@Override
	public void perform(final Practicum object) {
		assert object != null;

		this.repository.save(object);
	}

	@Override
	public void unbind(final Practicum object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "code", "title", "practicumAbstract", "goals", "estimatedTime", "company", "course");
		tuple.put("draftMode", object.isDraftMode());

		super.getResponse().setData(tuple);
	}
}

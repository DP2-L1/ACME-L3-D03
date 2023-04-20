
package acme.features.company.practicum;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.entities.practicum.Practicum;
import acme.framework.components.jsp.SelectChoices;
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
		final Course course;

		companyId = super.getRequest().getPrincipal().getActiveRoleId();
		company = this.repository.findOneCompanyById(companyId);

		object = new Practicum();
		object.setCode("");
		object.setTitle("");
		object.setPracticumAbstract("");
		object.setEstimatedTime(0);
		object.setGoals("");
		object.setCompany(company);
		object.setDraftMode(true);
		object.setHasAddendum(false);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Practicum object) {
		assert object != null;
		int courseId;
		Course course;

		courseId = super.getRequest().getData("course", int.class);
		super.bind(object, "code", "title", "practicumAbstract", "goals");
		course = this.repository.findOneCourseById(courseId);
		object.setCourse(course);
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
		Collection<Course> courses;
		final SelectChoices choices;
		courses = this.repository.findAllCourses();
		choices = SelectChoices.from(courses, "title", object.getCourse());

		tuple = super.unbind(object, "code", "title", "practicumAbstract", "goals", "estimatedTime", "draftMode");
		tuple.put("draftMode", object.isDraftMode());
		tuple.put("hasAddendum", object.isHasAddendum());
		tuple.put("course", choices.getSelected().getKey());
		tuple.put("courses", choices);

		super.getResponse().setData(tuple);
	}
}

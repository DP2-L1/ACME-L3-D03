
package acme.features.lecturer.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.framework.components.accounts.Principal;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerCourseUpdateService extends AbstractService<Lecturer, Course> {

	@Autowired
	protected LecturerCourseRepository repo;


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("id", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		Course object;
		int id;
		final Principal principal;
		final int userAccountId;

		id = super.getRequest().getData("id", int.class);
		object = this.repo.findOneCourseById(id);
		principal = super.getRequest().getPrincipal();
		userAccountId = principal.getAccountId();

		status = object.getLecturer().getUserAccount().getId() == userAccountId && object.isDraftMode();

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Course object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repo.findOneCourseById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Course object) {
		assert object != null;
		super.bind(object, "code", "title", "courseAbstract", "courseType", "retailPrice", "link");
	}

	@Override
	public void validate(final Course object) {
		assert object != null;
		if (!super.getBuffer().getErrors().hasErrors("code")) {
			Course instance;
			final String code = object.getCode();
			instance = this.repo.findOneCourseByCode(code);
			super.state(instance == null, "code", "lecturer.course.error.code.duplicated");
		}
		if (!super.getBuffer().getErrors().hasErrors("retailPrice")) {
			final double retailPrice = object.getRetailPrice().getAmount();
			super.state(retailPrice >= 0, "retailPrice", "lecturer.course.error.retailPrice.negative");
		}
	}

	@Override
	public void perform(final Course object) {
		assert object != null;

		this.repo.save(object);
	}

	@Override
	public void unbind(final Course object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "code", "title", "courseAbstract", "courseType", "retailPrice", "link");

		super.getResponse().setData(tuple);
	}
}


package acme.features.lecturer.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.course.Course;
import acme.framework.components.models.Tuple;
import acme.framework.controllers.HttpMethod;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerCourseCreateService extends AbstractService<Lecturer, Course> {

	@Autowired
	protected LecturerCourseRepository repo;


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		boolean status;
		status = super.getRequest().getPrincipal().hasRole(Lecturer.class);
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Course object;
		Lecturer lecturer;
		int userAccountId;

		userAccountId = super.getRequest().getPrincipal().getAccountId();
		lecturer = this.repo.findOneLecturerById(userAccountId);

		object = new Course();
		object.setLecturer(lecturer);
		object.setDraftMode(true);
		object.setLecturer(lecturer);
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Course object) {
		assert object != null;

		int activeRoleId;
		Lecturer lecturer;

		activeRoleId = super.getRequest().getPrincipal().getActiveRoleId();
		lecturer = this.repo.findOneLecturerById(activeRoleId);

		super.bind(object, "code", "title", "courseAbstract", "retailPrice", "link");
		object.setLecturer(lecturer);
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
		tuple = super.unbind(object, "code", "title", "courseAbstract", "retailPrice", "link");
		super.getResponse().setData(tuple);
	}

	@Override
	public void onSuccess() {
		if (super.getRequest().getMethod().equals(HttpMethod.POST))
			PrincipalHelper.handleUpdate();
	}

}

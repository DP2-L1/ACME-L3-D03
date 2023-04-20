
package acme.features.student.enrolment;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.enrolment.Enrolment;
import acme.framework.components.accounts.Principal;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Student;

@Service
public class StudentEnrolmentListService extends AbstractService<Student, Enrolment> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected StudentEnrolmentRepository repository;

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
		Collection<Enrolment> objects;
		final Principal principal = super.getRequest().getPrincipal();
		final int userAccountId = principal.getActiveRoleId();
		objects = this.repository.findEnrolmentsByStudentId(userAccountId);
		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final Enrolment object) {
		assert object != null;
		Tuple tuple;
		tuple = super.unbind(object, "code", "motivation", "goals");
		super.getResponse().setData(tuple);
	}

}

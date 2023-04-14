package acme.features.authenticated.student;

import org.hibernate.cfg.BinderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.AbstractService;

import acme.framework.components.accounts.Authenticated;
import acme.framework.helpers.PrincipalHelper;
import acme.roles.Student;

@Service
public class AuthenticatedStudentUpdateService extends AbstractService<Authenticated, Student> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedStudentRepository repo;

	// AbstractService interface ----------------------------------------------

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void load() {
		Principal principal;
		Student st;
		int userAccountId;
		principal = super.getRequest().getPrincipal();
		userAccountId = principal.getAccountId();
		st = this.repo.findOneStudentByUserAccountId(userAccountId);
		super.getBuffer().setData(st);
	}

	@Override
	public void bind(final Student st) {
		assert st != null;
		super.bind(st, "statement", "strongFeatures", "weakFeatures", "link");
	}

	@Override
	public void perform(final Student st) {
		assert st != null;
		this.repo.save(st);
	}

	@Override
	public void validate(final Student st) {
		assert st != null;
	}

	@Override
	public void onSuccess() {
		if (super.getRequest().getMethod().equals(HttpMethod.POST))
			PrincipalHelper.handleUpdate();
	}

	@Override
	public void unbind(final Student st) {
		assert st != null;
		Tuple tuple;
		tuple = BinderHelper.unbind(st, "statement", "strongFeatures", "weakFeatures", "link");
		super.getResponse().setData(tuple);
	}

}
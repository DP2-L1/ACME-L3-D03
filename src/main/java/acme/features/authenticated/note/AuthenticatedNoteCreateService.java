
package acme.features.authenticated.note;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.note.Note;
import acme.framework.components.accounts.Authenticated;
import acme.framework.components.accounts.Principal;
import acme.framework.components.accounts.UserAccount;
import acme.framework.components.models.Tuple;
import acme.framework.controllers.HttpMethod;
import acme.framework.helpers.MomentHelper;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractService;

@Service
public class AuthenticatedNoteCreateService extends AbstractService<Authenticated, Note> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedNoteRepository repository;

	// AbstractService<Authenticated, Note> ---------------------------


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
		Note object;
		Date moment;
		Principal principal;
		int userAccountId;
		UserAccount userAccount;
		principal = super.getRequest().getPrincipal();
		userAccountId = principal.getAccountId();
		userAccount = this.repository.findOneUserAccountById(userAccountId);
		moment = MomentHelper.getCurrentMoment();
		object = new Note();
		object.setInstationMoment(moment);
		object.setAuthor(userAccount.getUsername());

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Note object) {
		assert object != null;

		super.bind(object, "instationMoment", "title", "message", "author", "email", "link");
	}

	@Override
	public void validate(final Note object) {
		assert object != null;

		boolean confirmation;

		confirmation = super.getRequest().getData("confirmation", boolean.class);
		super.state(confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
	}

	@Override
	public void perform(final Note object) {
		assert object != null;
		Date moment;
		moment = MomentHelper.getCurrentMoment();
		object.setInstationMoment(moment);
		this.repository.save(object);
	}

	@Override
	public void unbind(final Note object) {
		assert object != null;
		Tuple tuple;
		tuple = super.unbind(object, "instationMoment", "title", "message", "author", "email", "link");
		tuple.put("confirmation", false);
		super.getResponse().setData(tuple);
	}

	@Override
	public void onSuccess() {
		if (super.getRequest().getMethod().equals(HttpMethod.POST))
			PrincipalHelper.handleUpdate();
	}

}

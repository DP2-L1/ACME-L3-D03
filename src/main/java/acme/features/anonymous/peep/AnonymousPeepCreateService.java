
package acme.features.anonymous.peep;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.peep.Peep;
import acme.framework.components.accounts.Anonymous;
import acme.framework.components.models.Tuple;
import acme.framework.helpers.MomentHelper;
import acme.framework.services.AbstractService;

@Service
public class AnonymousPeepCreateService extends AbstractService<Anonymous, Peep> {

	@Autowired
	protected AnonymousPeepRepository repository;


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
		Peep object;

		Date moment;

		moment = MomentHelper.getCurrentMoment();

		object = new Peep();
		object.setInstationMoment(moment);
		object.setTitle("");
		object.setNick("");
		object.setMessage("");
		object.setEmail("");
		object.setLink("");

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Peep object) {
		assert object != null;

		super.bind(object, "title", "nick", "message", "email", "link");
	}

	@Override
	public void validate(final Peep object) {
		assert object != null;
	}

	@Override
	public void perform(final Peep object) {
		assert object != null;

		Date moment;

		moment = MomentHelper.getCurrentMoment();
		object.setInstationMoment(moment);
		this.repository.save(object);
	}

	@Override
	public void unbind(final Peep object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "title", "message", "link", "nick", "email");

		super.getResponse().setData(tuple);
	}
}

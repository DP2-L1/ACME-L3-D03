
package acme.features.anonymous.peep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.peep.Peep;
import acme.framework.components.accounts.Anonymous;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AnonymousPeepShowService extends AbstractService<Anonymous, Peep> {

	@Autowired
	protected AnonymousPeepRepository repository;


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("id", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int id;
		Peep peep;

		id = super.getRequest().getData("id", int.class);
		peep = this.repository.findOnePeepById(id);
		status = peep != null;

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Peep object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOnePeepById(id);

		super.getBuffer().setData(object);

	}

	@Override
	public void unbind(final Peep object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "instantiationMoment", "title", "nick", "message", "email", "link");

		super.getResponse().setData(tuple);
	}

}

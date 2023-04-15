
package acme.features.anonymous.peep;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.peep.Peep;
import acme.framework.components.accounts.Anonymous;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AnonymousPeepListAllService extends AbstractService<Anonymous, Peep> {

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
		Collection<Peep> object;

		object = this.repository.findAllPeeps();

		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final Peep object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "reference", "status");
		tuple.put("title", object.getTitle());

		super.getResponse().setData(tuple);
	}
}

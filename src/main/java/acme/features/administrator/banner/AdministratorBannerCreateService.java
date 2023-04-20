
package acme.features.administrator.banner;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.Banner;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.helpers.MomentHelper;
import acme.framework.services.AbstractService;

@Service
public class AdministratorBannerCreateService extends AbstractService<Administrator, Banner> {

	@Autowired
	protected AdministratorBannerRepository repository;


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
		Banner object;

		Date moment;

		moment = MomentHelper.getCurrentMoment();

		object = new Banner();
		object.setInstantiationMoment(moment);
		object.setDisplayPeriodStart(moment);
		object.setDisplayPeriodEnd(moment);
		object.setPicture("");
		object.setSlogan("");
		object.setLink("");

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Banner object) {
		assert object != null;

		super.bind(object, "displayPeriodStart", "displayPeriodEnd", "picture", "slogan", "link");
	}

	@Override
	public void validate(final Banner object) {
		assert object != null;

		if (!super.getBuffer().getErrors().hasErrors("displayPeriodStart"))
			super.state(MomentHelper.isAfterOrEqual(object.getDisplayPeriodStart(), object.getInstantiationMoment()), "displayPeriodStart", "administrator.peep.form.error.start-after-instantiationMoment");

		if (!super.getBuffer().getErrors().hasErrors("displayPeriodEnd"))
			super.state(MomentHelper.isLongEnough(object.getDisplayPeriodStart(), object.getDisplayPeriodEnd(), 1, ChronoUnit.WEEKS), "displayPeriodEnd", "administrator.peep.form.error.at-least-1-week");

		if (!super.getBuffer().getErrors().hasErrors("displayPeriodEnd"))
			super.state(MomentHelper.isAfter(object.getDisplayPeriodEnd(), object.getDisplayPeriodStart()), "displayPeriodEnd", "administrator.peep.form.error.end-after-start");

	}

	@Override
	public void perform(final Banner object) {
		assert object != null;

		Date moment;

		moment = MomentHelper.getCurrentMoment();
		object.setInstantiationMoment(moment);
		this.repository.save(object);
	}

	@Override
	public void unbind(final Banner object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "displayPeriodStart", "displayPeriodEnd", "picture", "slogan", "link");

		super.getResponse().setData(tuple);
	}
}

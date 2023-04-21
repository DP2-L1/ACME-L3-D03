
package acme.features.assistant.tutorialSession;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tutorial.SessionType;
import acme.entities.tutorial.Tutorial;
import acme.entities.tutorial.TutorialSession;
import acme.framework.components.jsp.SelectChoices;
import acme.framework.components.models.Tuple;
import acme.framework.helpers.MomentHelper;
import acme.framework.services.AbstractService;
import acme.roles.Assistant;

@Service
public class AssistantTutorialSessionCreateService extends AbstractService<Assistant, TutorialSession> {

	@Autowired
	protected AssistantTutorialSessionRepository repository;


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("masterId", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int masterId;
		Tutorial tutorial;

		masterId = super.getRequest().getData("masterId", int.class);
		tutorial = this.repository.findOneTutorialById(masterId);
		status = tutorial != null && super.getRequest().getPrincipal().hasRole(tutorial.getAssistant());

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		TutorialSession object;
		int masterId;
		Tutorial tutorial;
		Date moment;

		moment = MomentHelper.getCurrentMoment();

		masterId = super.getRequest().getData("masterId", int.class);
		tutorial = this.repository.findOneTutorialById(masterId);

		object = new TutorialSession();
		object.setTitle("");
		object.setAbstractText("");
		object.setSessionType(SessionType.THEORY);
		object.setStartPeriod(moment);
		object.setEndPeriod(moment);
		object.setLink("");
		object.setTutorial(tutorial);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final TutorialSession object) {
		assert object != null;

		super.bind(object, "title", "abstractText", "sessionType", "startPeriod", "endPeriod", "link");
	}

	@Override
	public void validate(final TutorialSession object) {
		assert object != null;

		if (!super.getBuffer().getErrors().hasErrors("startPeriod")) {
			Date minDayAhead;

			minDayAhead = MomentHelper.deltaFromCurrentMoment(1, ChronoUnit.DAYS);
			super.state(MomentHelper.isAfter(object.getStartPeriod(), minDayAhead), "startPeriod", "assistant.TutorialSession.form.error.too-close");
		}

		if (!super.getBuffer().getErrors().hasErrors("endPeriod"))
			super.state(MomentHelper.isAfter(object.getEndPeriod(), object.getStartPeriod()), "endPeriod", "assistant.TutorialSession.form.error.end-after-start");

		if (!super.getBuffer().getErrors().hasErrors("endPeriod"))
			super.state(MomentHelper.isLongEnough(object.getStartPeriod(), object.getEndPeriod(), 1, ChronoUnit.HOURS), "endPeriod", "assistant.TutorialSession.form.error.at-least-1-hour");

		if (!super.getBuffer().getErrors().hasErrors("endPeriod")) {
			long moment1;
			long moment2;
			long length, threshold;

			moment1 = object.getStartPeriod().getTime();
			moment2 = object.getEndPeriod().getTime();

			length = moment2 - moment1;
			threshold = 5 * ChronoUnit.HOURS.getDuration().toMillis();

			super.state(Math.abs(length) <= Math.abs(threshold), "endPeriod", "assistant.TutorialSession.form.error.not-more-thant-5-hours");

		}
	}

	@Override
	public void perform(final TutorialSession object) {
		assert object != null;

		this.repository.save(object);
	}

	@Override
	public void unbind(final TutorialSession object) {
		assert object != null;

		Tuple tuple;
		SelectChoices choices;

		choices = SelectChoices.from(SessionType.class, object.getSessionType());

		tuple = super.unbind(object, "title", "abstractText", "sessionType", "startPeriod", "endPeriod", "link");
		tuple.put("masterId", super.getRequest().getData("masterId", int.class));
		tuple.put("sessionType", choices);
		tuple.put("draftMode", object.getTutorial().isDraftMode());

		super.getResponse().setData(tuple);
	}
}

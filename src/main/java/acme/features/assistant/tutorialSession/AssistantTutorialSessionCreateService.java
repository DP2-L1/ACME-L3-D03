
package acme.features.assistant.tutorialSession;

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

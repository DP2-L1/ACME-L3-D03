
package acme.features.assistant.tutorialSession;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tutorial.TutorialSession;
import acme.framework.controllers.AbstractController;
import acme.roles.Assistant;

@Controller
public class AssistantTutorialSessionController extends AbstractController<Assistant, TutorialSession> {

	@Autowired
	protected AssistantTutorialSessionListService	listService;

	@Autowired
	protected AssistantTutorialSessionShowService	showService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("list", this.listService);

	}
}

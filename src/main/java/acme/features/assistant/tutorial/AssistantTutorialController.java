
package acme.features.assistant.tutorial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tutorial.Tutorial;
import acme.framework.controllers.AbstractController;
import acme.roles.Assistant;

@Controller
public class AssistantTutorialController extends AbstractController<Assistant, Tutorial> {

	@Autowired
	protected AssistantTutorialListMineService	listMineService;

	@Autowired
	protected AssistantTutorialShowService		showService;

	@Autowired
	protected AssistantTutorialCreateService	createService;

	@Autowired
	protected AssistantTutorialUpdateService	updateService;

	@Autowired
	protected AssistantTutorialDeleteService	deleteService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("update", this.showService);
		super.addBasicCommand("delete", this.showService);

		super.addCustomCommand("list-mine", "list", this.listMineService);

	}
}

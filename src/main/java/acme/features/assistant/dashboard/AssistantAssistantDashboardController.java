
package acme.features.assistant.dashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.form.AssistantDashboard;
import acme.framework.controllers.AbstractController;
import acme.roles.Assistant;

@Controller
public class AssistantAssistantDashboardController extends AbstractController<Assistant, AssistantDashboard> {

	@Autowired
	protected AssistantAssistantDashboardShowService showService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("show", this.showService);
	}
}

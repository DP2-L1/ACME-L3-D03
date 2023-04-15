
package acme.features.anonymous.peep;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.peep.Peep;
import acme.framework.components.accounts.Anonymous;
import acme.framework.controllers.AbstractController;

@Controller
public class AnonymousPeepController extends AbstractController<Anonymous, Peep> {

	@Autowired
	protected AnonymousPeepShowService		showService;

	@Autowired
	protected AnonymousPeepListAllService	listAllService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("show", this.showService);
		super.addCustomCommand("list-all", "list", this.listAllService);
	}
}

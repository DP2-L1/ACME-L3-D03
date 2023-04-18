
package acme.features.authenticated.peep;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.peep.Peep;
import acme.framework.components.accounts.Authenticated;
import acme.framework.controllers.AbstractController;

@Controller
public class AuthenticatedPeepController extends AbstractController<Authenticated, Peep> {

	@Autowired
	protected AuthenticatedPeepShowService		showService;

	@Autowired
	protected AuthenticatedPeepListAllService	listAllService;

	@Autowired
	protected AuthenticatedPeepCreateService	createService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("create", this.createService);

		super.addCustomCommand("list-all", "list", this.listAllService);
	}
}

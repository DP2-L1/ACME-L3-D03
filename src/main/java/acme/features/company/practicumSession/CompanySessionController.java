
package acme.features.company.practicumSession;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.practicum.PracticumSession;
import acme.framework.controllers.AbstractController;
import acme.roles.Company;

@Controller
public class CompanySessionController extends AbstractController<Company, PracticumSession> {

	@Autowired
	private CompanySessionListService				listService;

	@Autowired
	private CompanySessionShowService				showService;

	@Autowired
	private CompanySessionCreateService				createService;

	@Autowired
	private CompanySessionUpdateService				updateService;

	@Autowired
	private CompanySessionDeleteService				deleteService;

	@Autowired
	private CompanySessionCreateAdddendumService	createAddendumService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("delete", this.deleteService);
		super.addBasicCommand("update", this.updateService);

		super.addCustomCommand("create-addendum", "create", this.createAddendumService);
	}
}

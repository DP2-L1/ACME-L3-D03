
package acme.features.lecturer.lecture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.lecture.Lecture;
import acme.framework.controllers.AbstractController;
import acme.roles.Lecturer;

@Controller
public class LecturerLectureController extends AbstractController<Lecturer, Lecture> {

	@Autowired
	protected LecturerLectureCreateService	createService;

	@Autowired
	protected LecturerLectureShowService	showService;

	@Autowired
	protected LecturerLectureListService	listService;

	@Autowired
	protected LecturerLectureListAllService	listAllService;

	@Autowired
	protected LecturerLectureUpdateService	updateService;

	@Autowired
	protected LecturerLectureDeleteService	deleteService;

	@Autowired
	protected LecturerLecturePublishService	publishService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("update", this.updateService);
		super.addBasicCommand("delete", this.deleteService);

		super.addCustomCommand("list-all", "list", this.listAllService);
		super.addCustomCommand("publish", "update", this.publishService);
	}

}

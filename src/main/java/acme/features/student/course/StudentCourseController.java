package acme.features.student.course;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.AbstractController;

import acme.entities.course.Course;
import acme.roles.Student;

@Controller
public class StudentCourseController extends AbstractController<Student, Course> {

	@Autowired
	protected StudentCourseListService listService;

	@Autowired
	protected StudentCourseShowService showService;

	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
	}
}

package acme.roles;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.Course;
import acme.entities.Lessons;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecturer {

	@NotBlank
	@Length(max = 75)
	protected String		almaMater;

	@NotBlank
	@Length(max = 100)
	protected String		resume;

	@NotBlank
	@Length(max = 100)
	protected String		qualifications;

	@URL
	protected String		link;

	@OneToMany
	protected List<Lessons>	lesson;

	@OneToMany
	protected List<Course>	course;

}

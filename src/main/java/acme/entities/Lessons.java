
package acme.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import acme.roles.Lecturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lessons {

	protected String		title;

	@OneToMany
	protected List<Lecture>	lectures;

	@ManyToOne
	protected Lecturer		lecturer;

}

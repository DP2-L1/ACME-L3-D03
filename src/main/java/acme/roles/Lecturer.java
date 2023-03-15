
package acme.roles;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.Course;
import acme.framework.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecturer extends AbstractRole {

	// Serialisation identifier ---------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Atributes ------------------------------------------------------------

	@NotBlank
	@Length(max = 75)
	protected String			almaMater;

	@NotBlank
	@Length(max = 100)
	protected String			resume;

	@NotBlank
	@Length(max = 100)
	protected String			qualifications;

	@URL
	protected String			link;

	@NotNull
	@ManyToOne
	protected Course			course;

}

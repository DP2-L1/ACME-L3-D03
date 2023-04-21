
package acme.entities.auditor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.entities.course.Course;
import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Audit extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{1,3}[0-9]{3}$")
	private String				code;

	@NotBlank
	@Length(max = 101, min = 0)
	private String				conclusion;

	@NotBlank
	@Length(max = 101, min = 0)
	private String				strongPoints;

	@NotBlank
	@Length(max = 101, min = 0)
	private String				weakPoints;

	@Valid
	@NotNull
	@ManyToOne
	protected Course			course;

}

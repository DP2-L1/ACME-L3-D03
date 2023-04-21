
package acme.entities.practicum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import acme.entities.course.Course;
import acme.framework.data.AbstractEntity;
import acme.roles.Company;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Practicum extends AbstractEntity {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "[A-Z]{1,3}\\d\\d{3}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@NotBlank
	@Length(min = 0, max = 76)
	protected String			title;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String			practicumAbstract;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String			goals;

	@NotNull
	@PositiveOrZero
	Integer						estimatedTime;

	protected boolean			draftMode;

	protected boolean			hasAddendum;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Company			company;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Course			course;
}

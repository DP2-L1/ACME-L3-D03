
package acme.entities.practicum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

	@Temporal(value = TemporalType.TIME)
	protected Date				estimatedTime;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Company			company;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Course			course;
}

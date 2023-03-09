package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.framework.data.AbstractEntity;
import acme.roles.Student;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enrolment extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "[A-Z]{1,3}[0-9][0-9]{3}")
	@NotBlank
	@Column(unique = true)
	protected String code;

	@NotBlank
	@Size(max = 75)
	protected String motivation;

	@NotBlank
	@Size(max = 100)
	protected String goals;

	@NotNull
	@Temporal(TemporalType.TIME)
	protected int workTimeInHours;

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	protected Student student;

	/*
	 * @Valid
	 * 
	 * @NotNull
	 * 
	 * @ManyToOne(optional = false) protected Course course;
	 */
}

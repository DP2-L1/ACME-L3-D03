
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Audit extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "[A-Z]{1,3}[0-9][0-9]{3}", message = "default.error.conversion")
	@NotBlank
	@Column(unique = true)
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

	// TODO: Computed as the mode of the marks in the corresponding auditing records; ties must be broken arbitrarily if neccesary
	private String				mark;

}

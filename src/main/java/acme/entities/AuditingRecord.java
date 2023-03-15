
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditingRecord extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 0, max = 76)
	private String				subject;

	@NotBlank
	@Length(min = 0, max = 101)
	private String				assessment;

	// TODO: At least one hour long
	@Temporal(TemporalType.TIME)
	@Past
	private Date				period;

	@Pattern(regexp = "A[+]?|[B-C]|F[-]?")
	private String				mark;

	@URL
	private String				link;

}

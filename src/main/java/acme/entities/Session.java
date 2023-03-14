
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Session extends AbstractEntity {

	@NotBlank
	@Length(min = 0, max = 76)
	protected String	title;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String	sessionAbstract;

	@Temporal(value = TemporalType.TIME)
	@FutureOrPresent
	protected Date		timePeriod;

	protected String	optionalLink;

	@ManyToOne()
	@Valid
	protected Practicum	keypracticum;
}


package acme.entities.practicum;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PracticumSession extends AbstractEntity {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 0, max = 76)
	protected String			title;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String			sessionAbstract;

	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull
	protected Date				timePeriodStart;

	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull
	protected Date				timePeriodEnd;

	protected String			optionalLink;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Practicum			practicum;
}

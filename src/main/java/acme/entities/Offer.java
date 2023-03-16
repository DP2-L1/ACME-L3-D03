
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends AbstractEntity {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	protected Date				instantiationMoment;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String			heading;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String			summary;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date				availabilityPeriod;

	@PositiveOrZero
	protected Integer			price;

	@URL
	protected String			optionalLink;

}

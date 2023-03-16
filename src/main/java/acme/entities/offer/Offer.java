
package acme.entities.offer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.components.datatypes.Money;
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
	@NotNull
	protected Date				availabilityPeriodStart;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				availabilityPeriodEnd;

	@NotNull
	protected Money				price;

	@URL
	protected String			optionalLink;

}

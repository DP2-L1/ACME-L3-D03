
package acme.entities.banner;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Banner extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date				instantiationMoment;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				displayPeriodStart;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				displayPeriodEnd;

	@URL
	protected String			picture;

	@NotBlank
	@Size(max = 76)
	protected String			slogan;

	@URL
	protected String			link;

}

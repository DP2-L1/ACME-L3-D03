
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
	private Date				instantiationMoment;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				displayPeriodStart;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				displayPeriodEnd;

	@URL
	private String				picture;

	@NotBlank
	@Size(max = 76)
	private String				slogan;

	@URL
	private String				link;

}

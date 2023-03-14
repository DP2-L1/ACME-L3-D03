
package acme.entities.bulletin;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.components.accounts.Administrator;
import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bulletin extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				instationMoment;

	@NotBlank
	@Length(max = 75)
	private String				title;

	@NotBlank
	@Length(max = 100)
	private String				message;

	@NotNull
	private Boolean				isCritical;

	@URL
	private String				link;

	@NotNull
	@Valid
	@ManyToOne
	private Administrator		administrador;

}

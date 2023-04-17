
package acme.entities.tutorial;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TutorialSession extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Size(max = 75)
	private String				title;

	@NotBlank
	@Size(max = 100)
	private String				abstractText;

	@Enumerated(EnumType.STRING)
	@NotNull
	private SessionType			sessionType;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				startPeriod;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				endPeriod;

	@URL
	private String				link;

	@NotNull
	@Valid
	@ManyToOne
	private Tutorial			tutorial;

}

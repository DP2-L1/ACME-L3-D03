
package acme.entities.tutorial;

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

import org.hibernate.validator.constraints.Range;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Session extends AbstractEntity {

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
	@Temporal(TemporalType.TIME)
	@Range(min = 1, max = 5)
	private Integer				duration;

	private String				link;

	@NotNull
	@Valid
	@ManyToOne
	private Tutorial			tutorial;

}

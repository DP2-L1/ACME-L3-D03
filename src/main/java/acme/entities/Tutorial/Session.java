
package acme.entities.Tutorial;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Min(value = 1)
	@Max(value = 5)
	private Integer				duration;

	private String				link;

	@ManyToOne
	private Tutorial			tutorial;

}

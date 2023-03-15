
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.enums.Indicator;
import acme.framework.data.AbstractEntity;
import acme.roles.Lecturer;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecture extends AbstractEntity {

	// Serialisation identifier ---------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Atributes ------------------------------------------------------------

	@NotBlank
	@Length(max = 75)
	protected String			title;

	@NotBlank
	@Length(max = 100)
	protected String			abstracto;

	//estimatedLearningTime
	@NotNull
	@PastOrPresent
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				startDate;

	@NotNull
	@PastOrPresent
	@Temporal(TemporalType.TIMESTAMP)
	protected Date				endDate;

	@NotBlank
	@Length(max = 100)
	protected String			body;

	protected Indicator			indicator;

	@URL
	protected String			link;

	@NotNull
	@ManyToOne
	protected Lecturer			lecturer;

}

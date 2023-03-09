
package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

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

	@PositiveOrZero
	protected Integer			estimatedLearningTime;

	@NotBlank
	@Length(max = 100)
	protected String			body;

	protected Boolean			indicator;

	@URL
	protected String			link;

	@ManyToOne
	protected Lecturer			lecturer;

}


package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecture {

	@NotBlank
	@Length(max = 75)
	protected String	title;

	@NotBlank
	@Length(max = 100)
	protected String	abstracto;

	@Positive
	protected Integer	estimatedLearningTime;

	@NotBlank
	@Length(max = 100)
	protected String	body;

	protected Boolean	indicator;

	@URL
	protected String	link;

	@ManyToOne
	protected Lessons	Lesson;

}

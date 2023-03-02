
package acme.entities;

import javax.persistence.Entity;
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
	private String	title;

	@NotBlank
	@Length(max = 100)
	private String	abstracto;

	@Positive
	private Integer	estimatedLearningTime;

	@NotBlank
	@Length(max = 100)
	private String	body;

	private Boolean	indicator;

	@URL
	private String	link;

}

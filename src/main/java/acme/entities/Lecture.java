
package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecture {

	@NotBlank
	@Length(max = 76)
	private String	title;

	@NotBlank
	@Length(max = 101)
	private String	abstracto;

	@Positive
	private Integer	estimatedLearningTime;

	@NotBlank
	@Length(max = 101)
	private String	body;

	private Boolean	theorical;

	private String	link;

}
